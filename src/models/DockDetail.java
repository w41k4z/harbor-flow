package models;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.object.relation.Relation;

@Table(name = "dock_detail", columnCount = 4)
public class DockDetail extends Relation<DockDetail> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "DKD", length = 7, sequence = "dock_detail_sequence")
    private String dockDetailID;

    @Column
    private Double length;

    @Column
    private Double width;

    @Column
    private Double depth;

    /* CONSTRUCTOR SECTION */
    public DockDetail() throws Exception {
        super();
    }

    /* SETTERS SECTION */
    public void setDockDetailID(String dockDetailID) {
        this.dockDetailID = dockDetailID;
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

    /* GETTERS SECTION */
    public String getDockDetailID() {
        return this.dockDetailID;
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

}
