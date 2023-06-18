package models;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.object.relation.Relation;

@Table(name = "boat_category", columnCount = 2)
public class BoatCategory extends Relation<BoatCategory> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "BTC", length = 7, sequence = "boat_category_sequence")
    private String boatCategoryID;

    @Column
    private String name;

    /* CONSTRUCTOR SECTION */
    public BoatCategory() throws Exception {
        super();
    }

    /* SETTERS SECTION */
    public void setBoatCategoryID(String boatCategoryID) {
        this.boatCategoryID = boatCategoryID;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* GETTERS SECTION */
    public String getBoatCategoryID() {
        return this.boatCategoryID;
    }

    public String getName() {
        return this.name;
    }
}
