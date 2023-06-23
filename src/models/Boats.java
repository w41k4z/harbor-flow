package models;

import orm.annotation.Column;
import orm.annotation.Table;
import orm.database.connection.DatabaseConnection;
import orm.database.object.relation.Relation;
import orm.database.object.view.View;

// VIEW
@Table(columnCount = 9)
public class Boats extends Relation<Boats> {
    /* FIELDS SECTION */
    @Column(name = "id")
    private String boatID;

    @Column
    private String name;

    @Column(name = "boat_category_id")
    private String boatCategoryID;

    @Column
    private String category;

    @Column(name = "boat_detail_id")
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

    @Column(name = "boat_flag_id")
    private String boatFlagID;

    @Column
    private String origin;

    /* CONSTRUCTION SECTION */
    public Boats() throws Exception {
        super();
    }

    /* SETTERS SECTION */
    public void setBoatID(String boatID) {
        this.boatID = boatID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBoatCategoryID(String boatCategoryID) {
        this.boatCategoryID = boatCategoryID;
    }

    public void setCategory(String type) {
        this.category = type;
    }

    public void setBoatDetailID(String boatDetailID) {
        this.boatDetailID = boatDetailID;
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

    public void setBoatFlagID(String boatFlagID) {
        this.boatFlagID = boatFlagID;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /* GETTERS SECTION */
    public String getBoatID() {
        return this.boatID;
    }

    public String getName() {
        return this.name;
    }

    public String getBoatCategoryID() {
        return this.boatCategoryID;
    }

    public String getCategory() {
        return this.category;
    }

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

    public String getBoatFlagID() {
        return this.boatFlagID;
    }

    public String getOrigin() {
        return this.origin;
    }

    /* OVERRIDES SECTION */
    @Override
    public Boats[] findAll(DatabaseConnection connection) throws Exception {
        return new View<Boats>("stock_state", Boats.class).findAll(connection);
    }

    @Override
    public Boats[] findAll(DatabaseConnection connection, String spec) throws Exception {
        return new View<Boats>("stock_state", Boats.class).findAll(connection, spec);
    }

    @Override
    public int create(DatabaseConnection connection) throws Exception {
        throw new Exception("Not an actual existing table");
    }

    @Override
    public int create(DatabaseConnection connection, String manualPK) throws Exception {
        throw new Exception("Not an actual existing table");
    }

    @Override
    public int update(DatabaseConnection connection) throws Exception {
        throw new Exception("Not an actual existing table");
    }

    @Override
    public int update(DatabaseConnection connection, String spec) throws Exception {
        throw new Exception("Not an actual existing table");
    }

    @Override
    public int delete(DatabaseConnection connection) throws Exception {
        throw new Exception("Not an actual existing table");
    }

    @Override
    public int delete(DatabaseConnection connection, String spec) throws Exception {
        throw new Exception("Not an actual existing table");
    }
}
