package models;

import java.sql.Timestamp;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.connection.DatabaseConnection;
import orm.database.object.relation.Relation;

@Table(name = "stopover", columnCount = 4)
public class Stopover extends Relation<Stopover> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "STP", length = 9, sequence = "stopover_sequence")
    private String stopoverID;

    @Column(name = "boat_id")
    private String boatID;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    private Boats boat;

    private Docks currentDock;

    private StopoverServices[] stopoverServices;

    /* CONSTRUCTOR SECTION */
    public Stopover() throws Exception {
        super();
    }

    /* SETTERS */
    public void setStopoverID(String stopoverID) {
        this.stopoverID = stopoverID;
    }

    public void setBoatID(String boatID) {
        this.boatID = boatID;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public void setBoat(Boats boat) {
        this.boat = boat;
    }

    public void setCurrentDock(Docks currentDock) {
        this.currentDock = currentDock;
    }

    public void setStopoverServices(StopoverServices[] stopoverServices) {
        this.stopoverServices = stopoverServices;
    }

    /* GETTERS */
    public String getStopoverID() {
        return stopoverID;
    }

    public String getBoatID() {
        return boatID;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public Boats getBoat() {
        return boat;
    }

    public Docks getCurrentDock() {
        return currentDock;
    }

    public StopoverServices[] getStopoverServices() {
        return stopoverServices;
    }

    /* METHODS SECTION */
    public StopoverServices getCurrentStopoverServices(DatabaseConnection connection) throws Exception {
        StopoverServices[] currentService = new StopoverServices().findAll(connection,
                "WHERE stopover_id = '" + this.getStopoverID()
                        + "' AND departure_date IS NULL ORDER BY arrival_date DESC");
        if (currentService.length != 0) {
            return currentService[0];
        }
        return null;
    }

    /* OVERRIDES SECTION */
    @Override
    public Stopover[] findAll(DatabaseConnection connection) throws Exception {
        Stopover[] stopovers = super.findAll(connection);
        for (Stopover stopover : stopovers) {
            stopover.setBoat(new Boats().findByPrimaryKey(connection, stopover.getBoatID()));
            stopover.setStopoverServices(new StopoverServices().findAll(connection,
                    "WHERE stopover_id = '" + stopover.getStopoverID() + "'"));
            StopoverServices currentStopoverService = stopover.getCurrentStopoverServices(connection);
            stopover.setCurrentDock(currentStopoverService == null ? null : currentStopoverService.getDock());
        }
        return stopovers;
    }

    @Override
    public Stopover[] findAll(DatabaseConnection connection, String spec) throws Exception {
        Stopover[] stopovers = super.findAll(connection, spec);
        for (Stopover stopover : stopovers) {
            stopover.setBoat(new Boats().findByPrimaryKey(connection, stopover.getBoatID()));
            stopover.setStopoverServices(new StopoverServices().findAll(connection,
                    "WHERE stopover_id = '" + stopover.getStopoverID() + "'"));
            stopover.setCurrentDock(stopover.getCurrentStopoverServices(connection).getDock());
        }
        return stopovers;
    }

    @Override
    public Stopover findByPrimaryKey(DatabaseConnection connection) throws Exception {
        Stopover stopover = super.findByPrimaryKey(connection);
        stopover.setBoat(new Boats().findByPrimaryKey(connection, stopover.getBoatID()));
        stopover.setStopoverServices(new StopoverServices().findAll(connection,
                "WHERE stopover_id = '" + stopover.getStopoverID() + "'"));
        return stopover;
    }

    @Override
    public Stopover findByPrimaryKey(DatabaseConnection connection, String id) throws Exception {
        Stopover stopover = super.findByPrimaryKey(connection, id);
        stopover.setBoat(new Boats().findByPrimaryKey(connection, stopover.getBoatID()));
        stopover.setStopoverServices(new StopoverServices().findAll(connection,
                "WHERE stopover_id = '" + stopover.getStopoverID() + "'"));
        return stopover;
    }
}
