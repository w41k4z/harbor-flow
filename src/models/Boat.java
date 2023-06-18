package models;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.object.relation.Relation;

@Table(name = "boat", columnCount = 5)
public class Boat extends Relation<Boat> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "BT", length = 7, sequence = "boat_sequence")
    private String boatID;

    @Column
    private String name;

    @Column(name = "type")
    private String typeID;

    @Column(name = "detail")
    private String detailID;

    @Column(name = "flag")
    private String flagID;

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

    public void setDetailID(String detailID) {
        this.detailID = detailID;
    }

    public void setFlagID(String flagID) {
        this.flagID = flagID;
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

    public String getDetailID() {
        return this.detailID;
    }

    public String getFlagID() {
        return this.flagID;
    }

}
