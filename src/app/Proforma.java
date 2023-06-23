package app;

import java.sql.Timestamp;

import models.Boats;

public class Proforma {
    /* FIELDS SECTION */
    private Boats boat;
    private String[] prestations;
    private Timestamp forecastingStartDate;
    private Timestamp forecastingEndDate;

    /* CONSTRUCTOR SECTION */
    public Proforma(Boats boat, String[] prestations, Timestamp from, Timestamp to) {
        this.setBoat(boat);
        this.setPrestations(prestations);
        this.setForecastingStartDate(from);
        this.setForecastingEndDate(to);
    }

    /* SETTERS SECTION */
    public void setBoat(Boats boat) {
        this.boat = boat;
    }

    public void setPrestations(String[] prestations) {
        this.prestations = prestations;
    }

    public void setForecastingStartDate(Timestamp startDate) {
        this.forecastingStartDate = startDate;
    }

    public void setForecastingEndDate(Timestamp endDate) {
        this.forecastingEndDate = endDate;
    }

    /* GETTERS SECTION */
    public Boats getBoat() {
        return this.boat;
    }

    public String[] getPrestations() {
        return this.prestations;
    }

    public Timestamp getForecastingStartDate() {
        return this.forecastingStartDate;
    }

    public Timestamp getForecastingEndDate() {
        return this.forecastingEndDate;
    }
}
