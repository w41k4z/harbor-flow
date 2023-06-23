package app;

import java.util.ArrayList;
import java.util.Arrays;

import comparator.ModelComparator;
import connection.AppConnection;
import models.Docks;
import models.PendingForecast;

public class HarborFlow {

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

    public ArrayList<DockQueuing> getAvailableDocks(DockQueuing[] dockQueuings) {
        ArrayList<DockQueuing> availableDocks = new ArrayList<DockQueuing>();
        for (int i = 0; i < dockQueuings.length; i++) {
            if (dockQueuings[i].getQueuingBoats().size() == 0) {
                availableDocks.add(dockQueuings[i]);
            }
        }
        return availableDocks.size() > 0 ? availableDocks : null;
    }

    public DockQueuing getSuitableDock(DockQueuing[] dockQueuings, PendingForecast pendingForecast) throws Exception {
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
    public void getSuitableDockByTime(DockQueuing[] dockQueuings, PendingForecast pendingForecast) {
        double waitingTime = Math.pow(10, 10);
        int dockIndex = -1;
        Proforma proforma = new Proforma(pendingForecast.getStopoverForecast().getBoat(),
                new String[] { "remorquage", "stationnement" }, pendingForecast.getStopoverForecast().getArrivalDate(),
                pendingForecast.getStopoverForecast().getDepartureDate());
    }
}
