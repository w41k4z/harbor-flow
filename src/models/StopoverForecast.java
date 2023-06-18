package models;

import java.sql.Timestamp;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.connection.DatabaseConnection;
import orm.database.object.relation.Relation;

@Table(name = "stopover_forecast", columnCount = 6)
public class StopoverForecast extends Relation<StopoverForecast> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "STF", length = 9, sequence = "stopover_forecast_sequence")
    private String stopoverForecastID;

    @Column(name = "source_id")
    private String sourceID;

    @Column(name = "source_date")
    private Timestamp souceDate;

    @Column(name = "boat_id")
    private String boatID;

    @Column(name = "arrival_date")
    private Timestamp arrivalDate;

    @Column(name = "departure_date")
    private Timestamp departureDate;

    private Boats boat;

    /* CONSTRUCTOR SECTION */
    public StopoverForecast() throws Exception {
        super();
    }

    /* SETTERS SECTION */
    public void setStopoverForecastID(String stopoverForecastID) {
        this.stopoverForecastID = stopoverForecastID;
    }

    public void setSourceID(String sourceID) {
        this.sourceID = sourceID;
    }

    public void setSouceDate(Timestamp souceDate) {
        this.souceDate = souceDate;
    }

    public void setBoatID(String boatID) {
        this.boatID = boatID;
    }

    public void setArrivalDate(Timestamp arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setDepartureDate(Timestamp departureDate) {
        this.departureDate = departureDate;
    }

    public void setBoat(Boats boat) {
        this.boat = boat;
    }

    /* GETTERS SECTION */
    public String getStopoverForecastID() {
        return this.stopoverForecastID;
    }

    public String getSourceID() {
        return this.sourceID;
    }

    public Timestamp getSouceDate() {
        return this.souceDate;
    }

    public String getBoatID() {
        return this.boatID;
    }

    public Timestamp getArrivalDate() {
        return this.arrivalDate;
    }

    public Timestamp getDepartureDate() {
        return this.departureDate;
    }

    public Boats getBoat() {
        return this.boat;
    }

    /* OVERRRIDES SECTION */
    @Override
    public StopoverForecast findByPrimaryKey(DatabaseConnection connection, String primaryKey) throws Exception {
        StopoverForecast stopoverForecast = super.findByPrimaryKey(connection, primaryKey);
        this.setBoat(new Boats().findByPrimaryKey(connection, stopoverForecast.getBoatID()));
        return stopoverForecast;
    }
}
