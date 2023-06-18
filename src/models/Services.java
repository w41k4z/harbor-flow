package models;

import orm.annotation.Column;
import orm.annotation.Table;
import orm.database.connection.DatabaseConnection;
import orm.database.object.relation.Relation;
import orm.database.object.view.View;

// VIEW
@Table(columnCount = 6)
public class Services extends Relation<Services> {
    /* FIELDS SECTION */
    @Column(name = "id")
    private String serviceID;

    @Column
    private String name;

    @Column(name = "service_price_id")
    private String servicePriceID;

    @Column(name = "boat_category_id")
    private String boatCategoryID;

    @Column(name = "hourly_tier")
    private String hourlyTier;

    @Column
    private Double duration;

    private ServicePriceDetail[] servicePriceDetails;

    /* CONSTRUCTOR SECTION */
    public Services() throws Exception {
        super();
    }

    /* SETTERS SECTION */
    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setServicePriceID(String servicePriceID) {
        this.servicePriceID = servicePriceID;
    }

    public void setBoatCategoryID(String boatCategoryID) {
        this.boatCategoryID = boatCategoryID;
    }

    public void setHourlyTier(String hourlyTier) {
        this.hourlyTier = hourlyTier;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public void setServicePriceDetails(ServicePriceDetail[] servicePriceDetails) {
        this.servicePriceDetails = servicePriceDetails;
    }

    /* GETTERS SECTION */
    public String getServiceID() {
        return this.serviceID;
    }

    public String getName() {
        return this.name;
    }

    public String getServicePriceID() {
        return this.servicePriceID;
    }

    public String getBoatCategoryID() {
        return this.boatCategoryID;
    }

    public String getHourlyTier() {
        return this.hourlyTier;
    }

    public Double getDuration() {
        return this.duration;
    }

    public ServicePriceDetail[] getServicePriceDetails() {
        return this.servicePriceDetails;
    }

    /* METHODS SECTION */
    public Double

    /* OVERRIDES SECTION */
    @Override
    public Services[] findAll(DatabaseConnection connection) throws Exception {
        Services[] services = new View<Services>("services", Services.class).findAll(connection);
        for (Services service : services) {
            service.setServicePriceDetails(new ServicePriceDetail().findAll(connection,
                    "WHERE service_price_id = '" + service.getServicePriceID()));
        }
        return services;
    }

    @Override
    public Services[] findAll(DatabaseConnection connection, String spec) throws Exception {
        Services[] services = new View<Services>("services", Services.class).findAll(connection, spec);
        for (Services service : services) {
            service.setServicePriceDetails(new ServicePriceDetail().findAll(connection,
                    "WHERE service_price_id = '" + service.getServicePriceID()));
        }
        return services;
    }

    @Override
    public Services findByPrimaryKey(DatabaseConnection connection, String primaryKey) throws Exception {
        Services service = super.findByPrimaryKey(connection, primaryKey);
        service.setServicePriceDetails(new ServicePriceDetail().findAll(connection,
                "WHERE service_price_id = '" + service.getServicePriceID()));
        return service;
    }

    @Override
    public Services findByPrimaryKey(DatabaseConnection connection) throws Exception {
        return this.findByPrimaryKey(connection, this.getServiceID());
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
