package models;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.object.relation.Relation;

@Table(name = "boat_detail", columnCount = 6)
public class BoatDetail extends Relation<BoatDetail> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "BTD", length = 7, sequence = "boat_detail_sequence")
    private String boatDetailID;

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

    /* CONSTRUCTOR SECTION */
    public BoatDetail() throws Exception {
        super();
    }

    /* SETTERS SECTION */
    public void setBoatDetailID(String boatDetailID) {
        this.boatDetailID = boatDetailID;
    }

    public void setLength(Double length) {
        if (length > 0) {
            this.length = length;
        }
    }

    public void setWidth(Double width) {
        if (width > 0) {
            this.width = width;
        }
    }

    public void setDepth(Double depth) {
        if (depth > 0) {
            this.depth = depth;
        }
    }

    public void setWeight(Double weight) {
        if (weight > 0) {
            this.weight = weight;
        }
    }

    public void setTowing(Double towing) {
        if (towing > 0) {
            this.towing = towing;
        }
    }

    /* GETTERS SECTION */
    public String getBoatDetailID() {
        return this.boatDetailID;
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
}
