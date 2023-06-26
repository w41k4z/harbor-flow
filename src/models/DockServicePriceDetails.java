package models;

import java.sql.Time;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.object.relation.Relation;

@Table(name = "dock_service_price_details", columnCount = 7)
public class DockServicePriceDetails extends Relation<DockServicePriceDetails> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "SRPD", length = 8, sequence = "service_price_detail_sequence")
    private String dockServicePriceDetailsID;

    @Column(name = "dock_service_price_id")
    private String dockServicePriceID;

    @Column(name = "i_th_hourly_tier")
    private Integer i_Th_hourlyTier;

    @Column(name = "from_time")
    private Time fromTime;

    @Column(name = "to_time")
    private Time toTime;

    @Column(name = "national_price")
    private Double nationalPrice;

    @Column(name = "international_price")
    private Double internationalPrice;

    /* CONSTRUCTOR SECTION */
    public DockServicePriceDetails() throws Exception {
        super();
    }

    /* SETTERS SECTION */
    public void setDockServicePriceDetailsID(String dockServicePriceDetailsID) {
        this.dockServicePriceDetailsID = dockServicePriceDetailsID;
    }

    public void setDockServicePriceID(String dockServicePriceID) {
        this.dockServicePriceID = dockServicePriceID;
    }

    public void setI_Th_hourlyTier(Integer i_Th_hourlyTier) {
        if (i_Th_hourlyTier > 0) {
            this.i_Th_hourlyTier = i_Th_hourlyTier;
        }
    }

    public void setFromTime(Time fromTime) {
        this.fromTime = fromTime;
    }

    public void setToTime(Time toTime) {
        this.toTime = toTime;
    }

    public void setNationalPrice(Double nationalPrice) {
        if (nationalPrice > 0) {
            this.nationalPrice = nationalPrice;
        }
    }

    public void setInternationalPrice(Double internationalPrice) {
        if (internationalPrice > 0) {
            this.internationalPrice = internationalPrice;
        }
    }

    /* GETTERS SECTION */
    public String getDockServicePriceDetailsID() {
        return this.dockServicePriceDetailsID;
    }

    public String getDockServicePriceID() {
        return this.dockServicePriceID;
    }

    public Integer getI_Th_hourlyTier() {
        return this.i_Th_hourlyTier;
    }

    public Time getFromTime() {
        return this.fromTime;
    }

    public Time getToTime() {
        return this.toTime;
    }

    public Double getNationalPrice() {
        return this.nationalPrice;
    }

    public Double getInternationalPrice() {
        return this.internationalPrice;
    }

}
