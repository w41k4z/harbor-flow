package models;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.object.relation.Relation;

@Table(name = "dock", columnCount = 3)
public class Dock extends Relation<Dock> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "DOK", length = 7, sequence = "dock_sequence")
    private String dockID;

    @Column
    private String name;

    @Column(name = "detail")
    private String detailID;

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

    public void setDetailID(String detailID) {
        this.detailID = detailID;
    }

    /* GETTERS SECTION */
    public String getDockID() {
        return this.dockID;
    }

    public String getName() {
        return this.name;
    }

    public String getDetailID() {
        return this.detailID;
    }

}