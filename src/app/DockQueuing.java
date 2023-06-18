package app;

import java.util.ArrayList;

import models.Docks;
import models.PendingForecast;

public class DockQueuing {
    /* FIELDS SECTION */
    private Docks dock;
    private ArrayList<PendingForecast> queuingBoats;

    /* CONSTRUCTOR SECTION */
    public DockQueuing(Docks dock) {
        this.setDock(dock);
        ;
        this.queuingBoats = new ArrayList<PendingForecast>();
    }

    /* SETTERS SECTION */
    public void setDock(Docks dock) {
        this.dock = dock;
    }

    public void setQueuingBoats(ArrayList<PendingForecast> boats) {
        this.queuingBoats = boats;
    }

    /* GETTERS SECTION */
    public Docks getDock() {
        return this.dock;
    }

    public ArrayList<PendingForecast> getQueuingBoats() {
        return this.queuingBoats;
    }

    /* METHODS SECTION */
    public void addToQueu(PendingForecast pendingForecast) throws Exception {
        if (!(this.dock.getDepth() > pendingForecast.getStopoverForecast().getBoat().getDepth())) {
            throw new Exception("Not suitable");
        }
        this.queuingBoats.add(pendingForecast);
    }
}