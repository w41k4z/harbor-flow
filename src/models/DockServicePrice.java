package models;

import java.util.ArrayList;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.connection.DatabaseConnection;
import orm.database.object.relation.Relation;

@Table(name = "dock_service_price", columnCount = 4)
public class DockServicePrice extends Relation<DockServicePrice> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "DSRP", length = 10, sequence = "dock_service_price_sequence")
    private String dockServicePriceID;

    @Column(name = "dock_service_id")
    private String dockServiceID;

    @Column(name = "boat_category_id")
    private String boatCategoryID;

    @Column(name = "hourly_tier")
    private Double hourlyTier;

    private BoatCategory boatCategory;

    private DockServicePriceDetails[] dockServicePriceDetails;

    /* CONSTRUCTOR SECTION */
    public DockServicePrice() throws Exception {
        super();
    }

    /* SETTERS SECTION */
    public void setDockServicePriceID(String dockServicePriceID) {
        this.dockServicePriceID = dockServicePriceID;
    }

    public void setDockServiceID(String dockServiceID) {
        this.dockServiceID = dockServiceID;
    }

    public void setBoatCategoryID(String boatCategoryID) {
        this.boatCategoryID = boatCategoryID;
    }

    public void setHourlyTier(Double hourlyTier) {
        if (hourlyTier > 0) {
            this.hourlyTier = hourlyTier;
        }
    }

    public void setBoatCategory(BoatCategory boatCategory) {
        this.boatCategory = boatCategory;
    }

    public void setDockServicePriceDetails(DockServicePriceDetails[] dockServicePriceDetails) {
        this.dockServicePriceDetails = dockServicePriceDetails;
    }

    /* GETTERS SECTION */
    public String getDockServicePriceID() {
        return this.dockServicePriceID;
    }

    public String getDockServiceID() {
        return this.dockServiceID;
    }

    public String getBoatCategoryID() {
        return this.boatCategoryID;
    }

    public Double getHourlyTier() {
        return this.hourlyTier;
    }

    public BoatCategory getBoatCategory() {
        return this.boatCategory;
    }

    public DockServicePriceDetails[] getDockServicePriceDetails() {
        return this.dockServicePriceDetails;
    }

    public DockServicePriceDetails[] getTierDockServicePriceDetails(int tier) {
        ArrayList<DockServicePriceDetails> allDockServicePriceDetails = new ArrayList<>();
        for (DockServicePriceDetails dockServicePriceDetail : this.dockServicePriceDetails) {
            if (dockServicePriceDetail.getI_Th_hourlyTier() == tier) {
                allDockServicePriceDetails.add(dockServicePriceDetail);
            }
        }
        return allDockServicePriceDetails.toArray(new DockServicePriceDetails[allDockServicePriceDetails.size()]);
    }

    /* OVERRIDES SECTION */
    @Override
    public DockServicePrice[] findAll(DatabaseConnection connection) throws Exception {
        DockServicePrice[] dockServicePrices = super.findAll(connection);
        for (DockServicePrice dockServicePrice : dockServicePrices) {
            dockServicePrice.setBoatCategory(
                    new BoatCategory().findByPrimaryKey(connection, dockServicePrice.getBoatCategoryID()));
            dockServicePrice.setDockServicePriceDetails(new DockServicePriceDetails().findAll(connection,
                    "WHERE dock_service_price_id = '" + dockServicePrice.getDockServicePriceID()
                            + "' ORDER BY i_th_hourly_tier, from_time"));
        }
        return dockServicePrices;
    }

    @Override
    public DockServicePrice[] findAll(DatabaseConnection connection, String spec) throws Exception {
        DockServicePrice[] dockServicePrices = super.findAll(connection, spec);
        for (DockServicePrice dockServicePrice : dockServicePrices) {
            dockServicePrice.setBoatCategory(
                    new BoatCategory().findByPrimaryKey(connection, dockServicePrice.getBoatCategoryID()));
            dockServicePrice.setDockServicePriceDetails(new DockServicePriceDetails().findAll(connection,
                    "WHERE dock_service_price_id = '" + dockServicePrice.getDockServicePriceID()
                            + "' ORDER BY i_th_hourly_tier, from_time"));
        }
        return dockServicePrices;
    }
}
