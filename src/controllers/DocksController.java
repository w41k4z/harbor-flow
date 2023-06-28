package controllers;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

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
import models.Currency;
import models.Dock;
import models.DockService;
import models.DockServicePrice;
import models.DockServicePriceDetails;
import orm.database.connection.DatabaseConnection;
import orm.utilities.Treatment;

@ModelController(route = "/docks")
@Scope(Scopes.SINGLETON)
public class DocksController {

    @Auth
    @UrlMapping(url = "/new", method = HttpMethods.POST)
    public ModelView newBoat(
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String name,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) Double length,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) Double width,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) Double depth,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String currency) throws Exception {

        DatabaseConnection connection = new AppConnection().defaultConnection();
        try {
            Dock dock = new Dock();
            dock.setName(name);
            dock.setLength(length);
            dock.setWidth(width);
            dock.setDepth(depth);
            dock.setCurrencyID(currency);
            dock.create(connection);

            connection.commit();
            connection.close();

            return new IndexController().page("docks");
        } catch (Exception e) {
            connection.close();
            throw e;
        }
    }

    @UrlMapping(url = "/{dockID}/new-service", method = HttpMethods.POST)
    public ModelView newDockService(
            @HttpParam(type = HttpParameters.PATH_VARIABLE) String dockID,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String categoryID,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String prestation,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) Double hourlyTier,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) Integer[] hourlyTiers,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) Time[] fromTimes,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) Time[] toTimes,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) Double[] nationals,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) Double[] internationals,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String[] currencies)
            throws Exception {

        DatabaseConnection connection = new AppConnection().defaultConnection();
        try {
            Dock dock = new Dock().findByPrimaryKey(connection, dockID);

            if (dock == null) {
                throw new Exception("Dock not found");
            }

            Timestamp currentTimestamp = Treatment.getCurrentTimeStamp(true);

            DockService service = null;
            try {
                // it will raise an index out of bound exception if the service is not found
                service = new DockService().findAll(connection,
                        "WHERE dock_id='" + dockID + "' AND service_id='" + prestation + "'")[0];
            } catch (Exception e) {
                service = new DockService();
                service.setDockID(dockID);
                service.setServiceID(prestation);
                service.create(connection);
            }

            DockServicePrice servicePrice = new DockServicePrice();
            servicePrice.setBoatCategoryID(categoryID);
            servicePrice.setDockServiceID(service.getDockServiceID());
            servicePrice.setHourlyTier(hourlyTier);
            servicePrice.create(connection);

            for (int i = 0; i < hourlyTiers.length; i++) {
                DockServicePriceDetails servicePriceDetails = new DockServicePriceDetails();
                servicePriceDetails.setDockServicePriceID(servicePrice.getDockServicePriceID());
                servicePriceDetails.setI_Th_hourlyTier(hourlyTiers[i]);
                servicePriceDetails.setFromTime(fromTimes[i]);
                servicePriceDetails.setToTime(toTimes[i]);
                servicePriceDetails.setNationalPrice(nationals[i]);

                Currency currency = new Currency().findByPrimaryKey(connection, currencies[i]);
                currency.setValue(internationals[i]);
                servicePriceDetails.setInternationalPrice(
                        currency.getConversionTo(connection, dock.getCurrencyID(), currentTimestamp));

                servicePriceDetails.create(connection);
            }

            connection.commit();
            connection.close();

            return new IndexController().page("docks");
        } catch (Exception e) {
            connection.rollback();
            connection.close();
            throw e;
        }
    }
}
