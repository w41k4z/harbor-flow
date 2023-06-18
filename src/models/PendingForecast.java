package models;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.connection.DatabaseConnection;
import orm.database.object.relation.Relation;

@Table(name = "pending_forecast", columnCount = 2)
public class PendingForecast extends Relation<PendingForecast> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "PFC", length = 9, sequence = "pending_forecast_sequence")
    private String pendingForecastID;

    @Column(name = "stopover_forecast_id")
    private String stopoverForecastID;

    private StopoverForecast stopoverForecast;

    /* CONSTRUCTOR SECTION */
    public PendingForecast() throws Exception {
        super();
    }

    /* SETTERS SECTION */
    public void setPendingForecastID(String pendingForecastID) {
        this.pendingForecastID = pendingForecastID;
    }

    public void setStopoverForecastID(String stopoverForecastID) {
        this.stopoverForecastID = stopoverForecastID;
    }

    public void setStopoverForecast(StopoverForecast stopoverForecast) {
        this.stopoverForecast = stopoverForecast;
    }

    /* GETTERS SECTION */
    public String getPendingForecastID() {
        return this.pendingForecastID;
    }

    public String getStopoverForecastID() {
        return this.stopoverForecastID;
    }

    public StopoverForecast getStopoverForecast() {
        return this.stopoverForecast;
    }

    /* OVERRIDES SECTION */
    @Override
    public PendingForecast[] findAll(DatabaseConnection connection, String spec) throws Exception {
        PendingForecast[] pendingForecasts = super.findAll(connection, spec);
        for (PendingForecast pendingForecast : pendingForecasts) {
            pendingForecast.setStopoverForecast(
                    new StopoverForecast().findByPrimaryKey(connection, pendingForecast.getStopoverForecastID()));
        }
        return pendingForecasts;
    }

    @Override
    public PendingForecast[] findAll(DatabaseConnection connection) throws Exception {
        return this.findAll(connection,
                "JOIN stopover_forecast ON stopover_forecast.id = pending_forecast.id ORDER BY stopover_forecast.arrival_date");
    }
}
