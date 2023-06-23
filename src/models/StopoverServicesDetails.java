package models;

import java.sql.Timestamp;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.object.relation.Relation;

@Table(name = "stopover_services_details", columnCount = 7)
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
}
