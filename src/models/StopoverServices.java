package models;

import java.sql.Timestamp;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.connection.DatabaseConnection;
import orm.database.object.relation.Relation;

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

    private Dock dock;

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

    public void setDock(Dock dock) {
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

    public Dock getDock() {
        return dock;
    }

    public StopoverServicesDetails[] getStopoverServicesDetails() {
        return stopoverServicesDetails;
    }

    /* OVERRIDES SECTION */
    @Override
    public StopoverServices[] findAll(DatabaseConnection connection) throws Exception {
        StopoverServices[] stopoverServices = super.findAll(connection);
        for (StopoverServices stopoverService : stopoverServices) {
            stopoverService.setDock(new Dock().findByPrimaryKey(connection, stopoverService.getDockID()));
            stopoverService.setStopoverServicesDetails(new StopoverServicesDetails().findAll(connection,
                    "stopover_services_id = '" + stopoverService.getStopoverServicesID() + "'"));
        }
        return stopoverServices;
    }

    @Override
    public StopoverServices[] findAll(DatabaseConnection connection, String spec) throws Exception {
        StopoverServices[] stopoverServices = super.findAll(connection, spec);
        for (StopoverServices stopoverService : stopoverServices) {
            stopoverService.setDock(new Dock().findByPrimaryKey(connection, stopoverService.getDockID()));
            stopoverService.setStopoverServicesDetails(new StopoverServicesDetails().findAll(connection,
                    "stopover_services_id = '" + stopoverService.getStopoverServicesID() + "'"));
        }
        return stopoverServices;
    }
}