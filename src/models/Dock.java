package models;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.object.relation.Relation;

@Table(name = "dock", columnCount = 6)
public class Dock extends Relation<Dock> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "DOK", length = 7, sequence = "dock_sequence")
    private String dockID;

    @Column
    private String name;

    @Column
    private Double length;

    @Column
    private Double width;

    @Column
    private Double depth;

    @Column(name = "currency_id")
    private String currencyID;

    /* CONSTRUCTION SECTION */
    public Dock() throws Exception {
        super();
    }

    /* SETTERS SECTION */
    public void setDockID(String dockID) {
        this.dockID = dockID;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setCurrencyID(String currencyID) {
        this.currencyID = currencyID;
    }

    /* GETTERS SECTION */
    public String getDockID() {
        return this.dockID;
    }

    public String getName() {
        return this.name;
    }

    public Double getLength() {
        return length;
    }

    public Double getWidth() {
        return width;
    }

    public Double getDepth() {
        return depth;
    }

    public String getCurrencyID() {
        return this.currencyID;
    }

}