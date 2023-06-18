package app;

import models.Boats;

public class Proforma {
    /* FIELDS SECTION */
    private Boats boat;
    private String[] prestations;

    /* CONSTRUCTOR SECTION */
    public Proforma(Boats boat, String[] prestations) {
        this.setBoat(boat);
        this.setPrestations(prestations);
    }

    /* SETTERS SECTION */
    public void setBoat(Boats boat) {
        this.boat = boat;
    }

    public void setPrestations(String[] prestations) {
        this.prestations = prestations;
    }

    /* GETTERS SECTION */
    public Boats getBoat() {
        return this.boat;
    }

    public String[] getPrestations() {
        return this.prestations;
    }
}
