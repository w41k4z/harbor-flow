package models;

import java.sql.Timestamp;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.object.relation.Relation;

@Table(name = "validated_stopover_service", columnCount = 4)
public class ValidatedStopoverService extends Relation<ValidatedStopoverService> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "VSTS", length = 9, sequence = "validated_stopover_service_sequence")
    private String validatedStopoverServiceID;

    @Column(name = "stopover_services_details_id")
    private String stopoverServicesDetailsID;

    @Column(name = "user_account_id")
    private String userAccountID;

    @Column(name = "action_date")
    private Timestamp actionDate;

    /* CONSTRUCTOR SECTION */
    public ValidatedStopoverService() throws Exception {
        super();
    }

    /* SETTERS */
    public void setValidatedStopoverServiceID(String validatedStopoverServiceID) {
        this.validatedStopoverServiceID = validatedStopoverServiceID;
    }

    public void setStopoverServicesDetailsID(String stopoverServicesDetailsID) {
        this.stopoverServicesDetailsID = stopoverServicesDetailsID;
    }

    public void setUserAccountID(String userAccountID) {
        this.userAccountID = userAccountID;
    }

    public void setActionDate(Timestamp actionDate) {
        this.actionDate = actionDate;
    }

    /* GETTERS */
    public String getValidatedStopoverServiceID() {
        return validatedStopoverServiceID;
    }

    public String getStopoverServicesDetailsID() {
        return stopoverServicesDetailsID;
    }

    public String getUserAccountID() {
        return userAccountID;
    }

    public Timestamp getActionDate() {
        return actionDate;
    }
}
