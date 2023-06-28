package models;

import java.sql.Timestamp;
import java.util.ArrayList;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.connection.DatabaseConnection;
import orm.database.object.relation.Relation;
import orm.utilities.Treatment;

@Table(name = "stopover_services", columnCount = 5)
public class StopoverServices extends Relation<StopoverServices> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "STPS", length = 9, sequence = "stopover_services_sequence")
    private String stopoverServicesID;

    @Column(name = "stopover_id")
    private String stopoverID;

    @Column(name = "dock_id")
    private String dockID;

    @Column(name = "arrival_date")
    private Timestamp arrivalDate;

    @Column(name = "departure_date")
    private Timestamp departureDate;

    private Docks dock;

    private StopoverServicesDetails[] stopoverServicesDetails;

    /* CONSTRUCTOR SECTION */
    public StopoverServices() throws Exception {
        super();
    }

    /* SETTERS */
    public void setStopoverServicesID(String stopoverServicesID) {
        this.stopoverServicesID = stopoverServicesID;
    }

    public void setStopoverID(String stopoverID) {
        this.stopoverID = stopoverID;
    }

    public void setDockID(String dockID) {
        this.dockID = dockID;
    }

    public void setArrivalDate(Timestamp arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setDepartureDate(Timestamp departureDate) {
        this.departureDate = departureDate;
    }

    public void setDock(Docks dock) {
        this.dock = dock;
    }

    public void setStopoverServicesDetails(StopoverServicesDetails[] stopoverServicesDetails) {
        this.stopoverServicesDetails = stopoverServicesDetails;
    }

    /* GETTERS */
    public String getStopoverServicesID() {
        return stopoverServicesID;
    }

    public String getStopoverID() {
        return stopoverID;
    }

    public String getDockID() {
        return dockID;
    }

    public Timestamp getArrivalDate() {
        return arrivalDate;
    }

    public Timestamp getDepartureDate() {
        return departureDate;
    }

    public Docks getDock() {
        return dock;
    }

    public StopoverServicesDetails[] getStopoverServicesDetails() {
        return stopoverServicesDetails;
    }

    /* METHODS SECTION */
    public ArrayList<Double[]> getInvoice(DatabaseConnection connection, Boats boat) throws Exception {
        ArrayList<Double[]> allCost = new ArrayList<>();
        for (StopoverServicesDetails stopoverServiceDetail : stopoverServicesDetails) {
            System.out.println("\t" + stopoverServiceDetail.getDockService().getService().getName());
            if (stopoverServiceDetail.getState() == 11) {
                Double[] amount = stopoverServiceDetail.getCost(boat);
                Currency dockCurrency = new Currency().findAll(connection,
                        "WHERE label = '" + this.getDock().getCurrency() + "'")[0];
                dockCurrency.setValue(amount[1]);
                Currency boatCurrency = boat.getCurrency(connection);
                allCost.add(amount);
                System.out.println("\t\tNationale: " + amount[0] + " " + this.getDock().getCurrency());
                System.out.println("\t\tInternationale: " + amount[1] + " " + this.getDock().getCurrency());
                if (!boatCurrency.getCurrencyID().equals(dockCurrency.getCurrencyID())) {
                    System.out.println("\t\t\t=> "
                            + dockCurrency.getConversionTo(connection, boatCurrency.getCurrencyID(),
                                    Treatment.getCurrentTimeStamp(true))
                            + " " + boatCurrency.getLabel());
                }
            }
        }
        return allCost;
    }

    /* OVERRIDES SECTION */
    @Override
    public StopoverServices[] findAll(DatabaseConnection connection) throws Exception {
        StopoverServices[] stopoverServices = super.findAll(connection);
        for (StopoverServices stopoverService : stopoverServices) {
            stopoverService.setDock(new Docks().findByPrimaryKey(connection, stopoverService.getDockID()));
            stopoverService.setStopoverServicesDetails(new StopoverServicesDetails().findAll(connection,
                    "WHERE stopover_services_id = '" + stopoverService.getStopoverServicesID() + "'"));
        }
        return stopoverServices;
    }

    @Override
    public StopoverServices[] findAll(DatabaseConnection connection, String spec) throws Exception {
        StopoverServices[] stopoverServices = super.findAll(connection, spec);
        for (StopoverServices stopoverService : stopoverServices) {
            stopoverService.setDock(new Docks().findByPrimaryKey(connection, stopoverService.getDockID()));
            stopoverService.setStopoverServicesDetails(new StopoverServicesDetails().findAll(connection,
                    "WHERE stopover_services_id = '" + stopoverService.getStopoverServicesID() + "'"));
        }
        return stopoverServices;
    }
}