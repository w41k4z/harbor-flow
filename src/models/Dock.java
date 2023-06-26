package models;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.object.relation.Relation;

@Table(name = "dock", columnCount = 4)
public class Dock extends Relation<Dock> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "DOK", length = 7, sequence = "dock_sequence")
    private String dockID;

    @Column
    private String name;

    @Column(name = "detail")
    private String detailID;

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

    public void setDetailID(String detailID) {
        this.detailID = detailID;
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

    public String getDetailID() {
        return this.detailID;
    }

    public String getCurrencyID() {
        return this.currencyID;
    }

}