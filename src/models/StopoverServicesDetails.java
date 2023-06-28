package models;

import java.sql.Time;
import java.sql.Timestamp;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.connection.DatabaseConnection;
import orm.database.object.relation.Relation;

@Table(name = "stopover_services_details", columnCount = 8)
public class StopoverServicesDetails extends Relation<StopoverServicesDetails> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "STSD", length = 9, sequence = "stopover_services_details_sequence")
    private String stopoverServicesDetailsID;

    @Column(name = "stopover_services_id")
    private String stopoverServicesID;

    @Column(name = "dock_service_id")
    private String dockServiceID;

    @Column(name = "user_account_id")
    private String userAccountID;

    @Column(name = "action_date")
    private Timestamp actionDate;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column
    private Integer state;

    private DockService dockService;

    /* CONSTRUCTOR SECTION */
    public StopoverServicesDetails() throws Exception {
        super();
    }

    /* SETTERS */
    public void setStopoverServicesDetailsID(String stopoverServicesDetailsID) {
        this.stopoverServicesDetailsID = stopoverServicesDetailsID;
    }

    public void setStopoverServicesID(String stopoverServicesID) {
        this.stopoverServicesID = stopoverServicesID;
    }

    public void setDockServiceID(String dockServiceID) {
        this.dockServiceID = dockServiceID;
    }

    public void setUserAccountID(String userAccountID) {
        this.userAccountID = userAccountID;
    }

    public void setActionDate(Timestamp actionDate) {
        this.actionDate = actionDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setDockService(DockService dockService) {
        this.dockService = dockService;
    }

    /* GETTERS */
    public String getStopoverServicesDetailsID() {
        return stopoverServicesDetailsID;
    }

    public String getStopoverServicesID() {
        return stopoverServicesID;
    }

    public String getDockServiceID() {
        return dockServiceID;
    }

    public String getUserAccountID() {
        return userAccountID;
    }

    public Timestamp getActionDate() {
        return actionDate;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public Integer getState() {
        return state;
    }

    public String getActualState() {
        switch (state) {
            case 1:
                return "Pending";
            case 11:
                return "Validated";
            case 21:
                return "Paid";
            default:
                return "Desconocido";
        }
    }

    public DockService getDockService() {
        return dockService;
    }

    /* METHODS SECTION */
    public Double[] getCost(Boats boat) throws Exception {
        double duration = (this.getEndDate().getTime() - this.getStartDate().getTime()) / (60 * 1000);
        DockServicePrice dockServicePrice = this.getDockService().getDockServicePriceByCategory(boat);
        double nationalCost = 0;
        double internationalCost = 0;
        double nationalAmount = 0;
        double internationalAmount = 0;
        int slice = (int) Math.ceil(duration / dockServicePrice.getHourlyTier());
        for (int i = 0; i < slice; i++) {
            DockServicePriceDetails[] details = dockServicePrice.getTierDockServicePriceDetails(i + 1);
            if (details.length > 0) {
                for (DockServicePriceDetails detail : details) {
                    Timestamp timestamp = new Timestamp(
                            this.getStartDate().getTime()
                                    + (long) (dockServicePrice.getHourlyTier() * 60 * 1000) * (i + 1));
                    Time toCheck = Time.valueOf(timestamp.toString().split(" ")[1].split("\\.")[0]);
                    Time from = detail.getFromTime();
                    Time to = detail.getToTime();
                    if (toCheck.after(from) && toCheck.before(to)) {
                        nationalAmount = detail.getNationalPrice();
                        internationalAmount = detail.getInternationalPrice();
                        break;
                    }
                }
            }
            nationalCost += nationalAmount;
            internationalCost += internationalAmount;
        }
        return new Double[] { nationalCost, internationalCost };
    }

    /* OVERRIDES SECTION */
    @Override
    public StopoverServicesDetails[] findAll(DatabaseConnection connection) throws Exception {
        StopoverServicesDetails[] stopoverServicesDetails = super.findAll(connection);
        for (StopoverServicesDetails stopoverServiceDetail : stopoverServicesDetails) {
            stopoverServiceDetail.setDockService(
                    new DockService().findByPrimaryKey(connection,
                            stopoverServiceDetail.getDockServiceID()));
        }
        return stopoverServicesDetails;
    }

    @Override
    public StopoverServicesDetails[] findAll(DatabaseConnection connection, String spec) throws Exception {
        StopoverServicesDetails[] stopoverServicesDetails = super.findAll(connection, spec);
        for (StopoverServicesDetails stopoverServiceDetail : stopoverServicesDetails) {
            stopoverServiceDetail.setDockService(
                    new DockService().findByPrimaryKey(connection,
                            stopoverServiceDetail.getDockServiceID()));
        }
        return stopoverServicesDetails;
    }
}
