package controllers;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import app.DockQueuing;
import app.Proforma;
import comparator.ModelComparator;
import connection.AppConnection;
import etu2011.framework.annotations.Auth;
import etu2011.framework.annotations.HttpParam;
import etu2011.framework.annotations.ModelController;
import etu2011.framework.annotations.Scope;
import etu2011.framework.annotations.UrlMapping;
import etu2011.framework.enumerations.HttpMethods;
import etu2011.framework.enumerations.HttpParameters;
import etu2011.framework.enumerations.Scopes;
import etu2011.framework.renderer.ModelView;
import models.Boats;
import models.DockService;
import models.Docks;
import models.PendingForecast;
import models.Stopover;
import models.StopoverServices;
import models.StopoverServicesDetails;
import orm.database.connection.DatabaseConnection;
import orm.utilities.Treatment;

@ModelController(route = "/harbor")
@Scope(Scopes.PROTOTYPE)
public class HarborFlowController {

    /* ROUTES */
    @Auth
    @UrlMapping(url = "/{page}")
    public ModelView pages(@HttpParam(type = HttpParameters.PATH_VARIABLE) String page) throws Exception {
        ModelView modelView = new ModelView("home/" + page + ".jsp");
        DatabaseConnection connection = new AppConnection().defaultConnection();
        modelView.addData("allBoats", new Boats().findAll(connection));
        modelView.addData("allDocks", new Docks().findAll(connection));
        modelView.addData("allPendingStopovers", new Stopover().findAll(connection, "WHERE state < 11"));
        connection.close();
        return modelView;
    }

    @Auth("capitainerie")
    @UrlMapping(url = "/stopover/new-stopover", method = HttpMethods.POST)
    public ModelView newStopover(
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String userID,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String boatID,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String dockID,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) Timestamp startDate)
            throws Exception {

        DatabaseConnection connection = new AppConnection().defaultConnection();

        // creating a new stopover
        Stopover stopover = new Stopover();
        stopover.setBoatID(boatID);
        stopover.setStartDate(startDate);
        stopover.create(connection);

        // fetching needed informations
        Docks dock = new Docks().findByPrimaryKey(connection, dockID);
        Boats boat = new Boats().findByPrimaryKey(connection, boatID);
        DockService dockService = dock.getServiceByName("remorquage");

        // creating a new stopover service from the current dock
        StopoverServices stopoverService = new StopoverServices();
        stopoverService.setStopoverID(stopover.getStopoverID());
        stopoverService.setDockID(dock.getDockID());
        stopoverService.setArrivalDate(startDate);
        stopoverService.create(connection);

        // inserting the service 'remorquage'
        StopoverServicesDetails stopoverServicesDetails = new StopoverServicesDetails();
        stopoverServicesDetails.setStopoverServicesID(stopoverService.getStopoverServicesID());
        stopoverServicesDetails.setDockServiceID(dockService.getDockServiceID());
        stopoverServicesDetails.setUserAccountID(userID);
        stopoverServicesDetails.setStartDate(startDate);
        Timestamp endDate = new Timestamp(
                startDate.getTime() + TimeUnit.MINUTES.toMillis(boat.getTowing().longValue()));
        stopoverServicesDetails.setEndDate(endDate);
        stopoverServicesDetails.setState(1);
        stopoverServicesDetails.create(connection);

        connection.commit();
        connection.close();

        return this.pages("stopover");
    }

    @Auth("capitainerie")
    @UrlMapping(url = "/stopover/change-dock/{stopoverID}", method = HttpMethods.POST)
    public ModelView changeDock(
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String userID,
            @HttpParam(type = HttpParameters.PATH_VARIABLE) String stopoverID,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String dockID) throws Exception {

        DatabaseConnection connection = new AppConnection().defaultConnection();

        // fetching needed informations
        Timestamp currentTimestamp = Treatment.getCurrentTimeStamp(true);
        Stopover stopover = new Stopover().findByPrimaryKey(connection, stopoverID);

        Docks dock = new Docks().findByPrimaryKey(connection, dockID);
        DockService dockTowingService = dock.getServiceByName("remorquage");

        Docks currentDock = new Docks().findByPrimaryKey(connection, stopover.getCurrentStopoverServices().getDockID());
        DockService dockParkingService = currentDock.getServiceByName("stationnement");

        // updating the stopover services
        StopoverServices currentStopoverService = stopover.getCurrentStopoverServices();
        currentStopoverService.setDepartureDate(currentTimestamp);
        currentStopoverService.update(connection);

        // inserting 'stationnement' service for the currentStopoverService
        StopoverServicesDetails currentStopoverServicesDetails = new StopoverServicesDetails();
        currentStopoverServicesDetails.setStopoverServicesID(currentStopoverService.getStopoverServicesID());
        currentStopoverServicesDetails.setDockServiceID(dockParkingService.getDockServiceID());
        currentStopoverServicesDetails.setUserAccountID(userID);
        currentStopoverServicesDetails.setStartDate(currentStopoverService.getArrivalDate());
        currentStopoverServicesDetails.setEndDate(currentTimestamp);
        currentStopoverServicesDetails.setState(1);
        currentStopoverServicesDetails.create(connection);

        // creating a new stopover service for the new dock
        StopoverServices newStopoverServices = new StopoverServices();
        newStopoverServices.setStopoverID(stopover.getStopoverID());
        newStopoverServices.setDockID(dock.getDockID());
        newStopoverServices.setArrivalDate(currentTimestamp);
        newStopoverServices.create(connection);

        // inserting the service 'remorquage'
        StopoverServicesDetails stopoverServicesDetails = new StopoverServicesDetails();
        stopoverServicesDetails.setStopoverServicesID(newStopoverServices.getStopoverServicesID());
        stopoverServicesDetails.setDockServiceID(dockTowingService.getDockServiceID());
        stopoverServicesDetails.setUserAccountID(userID);
        stopoverServicesDetails.setStartDate(currentTimestamp);
        Timestamp endDate = new Timestamp(
                currentTimestamp.getTime()
                        + TimeUnit.MINUTES.toMillis(stopover.getBoat().getTowing().longValue()));
        stopoverServicesDetails.setEndDate(endDate);
        stopoverServicesDetails.setState(1);
        stopoverServicesDetails.create(connection);

        connection.commit();
        connection.close();

        return this.pages("stopover");
    }

    @Auth("capitainerie")
    @UrlMapping(url = "/stopover/add-new-service", method = HttpMethods.POST)
    public ModelView addNewService(
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String userID,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String stopoverID,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String prestation,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) Timestamp startDate,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) Timestamp endDate) throws Exception {

        DatabaseConnection connection = new AppConnection().defaultConnection();

        // fetching needed informations
        Stopover stopover = new Stopover().findByPrimaryKey(connection, stopoverID);
        StopoverServices currentStopoverServices = stopover.getCurrentStopoverServices();
        Docks currentDock = new Docks().findByPrimaryKey(connection, currentStopoverServices.getDockID());

        // inserting the service for this current stopover current dock
        StopoverServicesDetails stopoverServicesDetails = new StopoverServicesDetails();
        stopoverServicesDetails.setStopoverServicesID(currentStopoverServices.getStopoverServicesID());
        stopoverServicesDetails.setDockServiceID(currentDock.getServiceByName(prestation).getDockServiceID());
        stopoverServicesDetails.setUserAccountID(userID);
        stopoverServicesDetails.setStartDate(startDate);
        stopoverServicesDetails.setEndDate(endDate);
        stopoverServicesDetails.setState(1);
        stopoverServicesDetails.create(connection);

        connection.commit();
        connection.close();

        return this.pages("stopover");
    }

    public void departure(
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String userID,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String stopoverID) throws Exception {

        DatabaseConnection connection = new AppConnection().defaultConnection();

        // fetching needed informations
        Timestamp currentTimestamp = Treatment.getCurrentTimeStamp(true);
        Stopover stopover = new Stopover().findByPrimaryKey(connection, stopoverID);
        StopoverServices currentStopoverServices = stopover.getCurrentStopoverServices();

        // updating the stopover services
        currentStopoverServices.setDepartureDate(currentTimestamp);
        currentStopoverServices.update(connection);

        // updating stopover
        stopover.setEndDate(currentTimestamp);
        stopover.update(connection);

        // inserting 'stationnement' service for the currentStopoverService
        Docks currentDock = new Docks().findByPrimaryKey(connection, currentStopoverServices.getDockID());
        DockService dockParkingService = currentDock.getServiceByName("stationnement");
        StopoverServicesDetails currentStopoverServicesDetails = new StopoverServicesDetails();
        currentStopoverServicesDetails.setStopoverServicesID(currentStopoverServices.getStopoverServicesID());
        currentStopoverServicesDetails.setDockServiceID(dockParkingService.getDockServiceID());
        currentStopoverServicesDetails.setUserAccountID(userID);
        currentStopoverServicesDetails.setStartDate(currentStopoverServices.getArrivalDate());
        currentStopoverServicesDetails.setEndDate(currentTimestamp);
        currentStopoverServicesDetails.setState(1);
        currentStopoverServicesDetails.create(connection);

        connection.commit();
        connection.close();

    }

    public void getPlanning() throws Exception {
        AppConnection connection = new AppConnection();

        Docks[] allDocks = new Docks().findAll(connection);
        // sorting docks by its depth
        Arrays.sort(allDocks, new ModelComparator(Docks.class, "depth"));

        PendingForecast[] allPendingForecasts = new PendingForecast().findAll(connection);
        DockQueuing[] dockQueuings = new DockQueuing[allDocks.length];
        for (int i = 0; i < allDocks.length; i++) {
            dockQueuings[i] = new DockQueuing(allDocks[i]);
        }

        int in = 0;
        while (in != allPendingForecasts.length) {
            ArrayList<DockQueuing> available = this.getAvailableDocks(dockQueuings);
            if (available != null) {
                DockQueuing[] availableDock = available.toArray(new DockQueuing[available.size()]);
                DockQueuing suitableDock = null;
                for (int j = 0; j < allPendingForecasts.length; j++) {
                    suitableDock = this.getSuitableDock(availableDock, allPendingForecasts[j]);
                    if (suitableDock != null) {
                        suitableDock.addToQueu(allPendingForecasts[j]);
                        in++;
                    }
                }
            } else {
                // queing
                for (int j = 0; j < dockQueuings.length; j++) {

                }
            }
        }

        connection.close();
    }

    /* METHODS SECTION */
    private ArrayList<DockQueuing> getAvailableDocks(DockQueuing[] dockQueuings) {
        ArrayList<DockQueuing> availableDocks = new ArrayList<DockQueuing>();
        for (int i = 0; i < dockQueuings.length; i++) {
            if (dockQueuings[i].getQueuingBoats().size() == 0) {
                availableDocks.add(dockQueuings[i]);
            }
        }
        return availableDocks.size() > 0 ? availableDocks : null;
    }

    private DockQueuing getSuitableDock(DockQueuing[] dockQueuings, PendingForecast pendingForecast) throws Exception {
        double totalCost = Math.pow(10, 10);
        int dockIndex = -1;
        Proforma proforma = new Proforma(pendingForecast.getStopoverForecast().getBoat(),
                new String[] { "remorquage", "stationnement" }, pendingForecast.getStopoverForecast().getArrivalDate(),
                pendingForecast.getStopoverForecast().getDepartureDate());
        for (int i = 0; i < dockQueuings.length; i++) {
            double cost = dockQueuings[i].getDock().estimateTotalCost(proforma);
            if (cost < totalCost && pendingForecast.getStopoverForecast().getBoat().getDepth() < dockQueuings[i]
                    .getDock().getDepth()) {
                totalCost = cost;
                dockIndex = i;
            }
        }
        return dockIndex != -1 ? dockQueuings[dockIndex] : null;
    }

    // for queuing
    private void getSuitableDockByTime(DockQueuing[] dockQueuings, PendingForecast pendingForecast) {
        double waitingTime = Math.pow(10, 10);
        int dockIndex = -1;
        Proforma proforma = new Proforma(pendingForecast.getStopoverForecast().getBoat(),
                new String[] { "remorquage", "stationnement" }, pendingForecast.getStopoverForecast().getArrivalDate(),
                pendingForecast.getStopoverForecast().getDepartureDate());
    }
}
