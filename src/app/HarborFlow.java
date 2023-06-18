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
            ArrayList<DockQueuing> available = new ArrayList<DockQueuing>();
            if (available != null) {
                for (int j = 0; j < dockQueuings.length; j++) {
                    try {
                        dockQueuings[j].addToQueu(allPendingForecasts[j]);
                        tempQueuing.add(dockQueuings[j]);
                        in++;
                    } catch (Exception e) {
                        index = j;
                        for (int k = 0; k < tempQueuing.size(); k++) {
                            try {
                                tempQueuing.get(k).addToQueu(allPendingForecasts[j]);
                                in++;
                            } catch (Exception e2) {
                                continue;
                            }
                        }
                    }
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

    public void getSuitableDock(DockQueuing[] dockQueuings, PendingForecast pendingForecast) throws Exception {
        for (int i = 0; i < dockQueuings.length; i++) {
            try {
                dockQueuings[i].addToQueu(pendingForecast);
                return;
            } catch (Exception e) {
                continue;
            }
        }
        throw new Exception("Not suitable");
    }
}
