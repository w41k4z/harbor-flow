package models;

import java.sql.Timestamp;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.object.relation.Relation;

@Table(name = "stopover_invoice", columnCount = 5)
public class StopoverInvoice extends Relation<StopoverInvoice> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "STPI", length = 9, sequence = "stopover_invoice_sequence")
    private String stopoverInvoicesID;

    @Column(name = "stopover_id")
    private String stopoverID;

    @Column(name = "user_account_id")
    private String userAccountID;

    @Column(name = "action_date")
    private Timestamp actionDate;

    @Column
    private Integer state;

    /* CONSTRUCTOR SECTION */
    public StopoverInvoice() throws Exception {
        super();
    }

    /* SETTERS */
    public void setStopoverInvoicesID(String stopoverInvoicesID) {
        this.stopoverInvoicesID = stopoverInvoicesID;
    }

    public void setStopoverID(String stopoverID) {
        this.stopoverID = stopoverID;
    }

    public void setUserAccountID(String userAccountID) {
        this.userAccountID = userAccountID;
    }

    public void setActionDate(Timestamp actionDate) {
        this.actionDate = actionDate;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    /* GETTERS */
    public String getStopoverInvoicesID() {
        return stopoverInvoicesID;
    }

    public String getStopoverID() {
        return stopoverID;
    }

    public String getUserAccountID() {
        return userAccountID;
    }

    public Timestamp getActionDate() {
        return actionDate;
    }

    public Integer getState() {
        return state;
    }
}
