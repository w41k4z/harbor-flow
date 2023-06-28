package models;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.object.relation.Relation;

@Table(name = "boat", columnCount = 10)
public class Boat extends Relation<Boat> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "BT", length = 7, sequence = "boat_sequence")
    private String boatID;

    @Column
    private String name;

    @Column(name = "type")
    private String typeID;

    @Column
    private Double length;

    @Column
    private Double width;

    @Column
    private Double depth;

    @Column
    private Double weight;

    @Column
    private Double towing;

    @Column(name = "flag")
    private String flagID;

    @Column(name = "currency_id")
    private String currencyID;

    /* CONSTRUCTION SECTION */
    public Boat() throws Exception {
        super();
    }

    /* SETTERS SECTION */
    public void setBoatID(String boatID) {
        this.boatID = boatID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setTowing(Double towing) {
        this.towing = towing;
    }

    public void setFlagID(String flagID) {
        this.flagID = flagID;
    }

    public void setCurrencyID(String currencyID) {
        this.currencyID = currencyID;
    }

    /* GETTERS SECTION */
    public String getBoatID() {
        return this.boatID;
    }

    public String getName() {
        return this.name;
    }

    public String getTypeID() {
        return this.typeID;
    }

    public Double getLength() {
        return this.length;
    }

    public Double getWidth() {
        return this.width;
    }

    public Double getDepth() {
        return this.depth;
    }

    public Double getWeight() {
        return this.weight;
    }

    public Double getTowing() {
        return this.towing;
    }

    public String getFlagID() {
        return this.flagID;
    }

    public String getCurrencyID() {
        return this.currencyID;
    }

}
