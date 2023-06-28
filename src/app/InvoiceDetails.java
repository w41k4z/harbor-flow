package app;

import java.util.ArrayList;

import models.Docks;
import models.StopoverServicesDetails;

public class InvoiceDetails {
    private Docks dock;
    private ArrayList<StopoverServicesDetails> services;
    private ArrayList<Double[]> amounts;

    public InvoiceDetails() {
    }

    public InvoiceDetails(Docks dock, ArrayList<StopoverServicesDetails> details, ArrayList<Double[]> amounts) {
        this.dock = dock;
        this.services = details;
        this.amounts = amounts;
    }

    public void setDock(Docks dock) {
        this.dock = dock;
    }

    public void setServices(ArrayList<StopoverServicesDetails> services) {
        this.services = services;
    }

    public void setAmounts(ArrayList<Double[]> amounts) {
        this.amounts = amounts;
    }

    public Docks getDock() {
        return this.dock;
    }

    public ArrayList<StopoverServicesDetails> getServices() {
        return this.services;
    }

    public ArrayList<Double[]> getAmounts() {
        return this.amounts;
    }

    public Double[] getTotal() {
        Double[] amounts = new Double[] { 0., 0. };
        for (Double[] amount : this.amounts) {
            amounts[0] += amount[0];
            amounts[1] += amount[1];
        }
        return amounts;
    }
}
