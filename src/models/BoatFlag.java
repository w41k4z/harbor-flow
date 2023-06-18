package models;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.object.relation.Relation;

@Table(name = "boat_flag", columnCount = 2)
public class BoatFlag extends Relation<BoatFlag> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "BTF", length = 7, sequence = "boat_flag_sequence")
    private String boatFlagID;

    @Column
    private String origin;

    /* CONSTRUCTOR SECTION */
    public BoatFlag() throws Exception {
        super();
    }

    /* SETTERS SECTION */
    public void setBoatFlagID(String boatFlagID) {
        this.boatFlagID = boatFlagID;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /* GETTERS SECTION */
    public String getBoatFlagID() {
        return this.boatFlagID;
    }

    public String getOrigin() {
        return this.origin;
    }
}
