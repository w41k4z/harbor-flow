package models;

import java.sql.Timestamp;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.object.relation.Relation;

@Table(name = "validated_stopover_invoice", columnCount = 4)
public class ValidatedStopoverInvoice extends Relation<ValidatedStopoverInvoice> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "VSTI", length = 9, sequence = "validated_stopover_invoice_sequence")
    private String validatedStopoverInvoiceID;

    @Column(name = "stopover_invoice_id")
    private String stopoverInvoiceID;

    @Column(name = "user_account_id")
    private String userAccountID;

    @Column(name = "action_date")
    private Timestamp actionDate;

    /* CONSTRUCTION SECTION */
    public ValidatedStopoverInvoice() throws Exception {
        super();
    }

    /* SETTERS */
    public void setValidatedStopoverInvoiceID(String validatedStopoverInvoiceID) {
        this.validatedStopoverInvoiceID = validatedStopoverInvoiceID;
    }

    public void setStopoverInvoiceID(String stopoverInvoiceID) {
        this.stopoverInvoiceID = stopoverInvoiceID;
    }

    public void setUserAccountID(String userAccountID) {
        this.userAccountID = userAccountID;
    }

    public void setActionDate(Timestamp actionDate) {
        this.actionDate = actionDate;
    }

    /* GETTERS */
    public String getValidatedStopoverInvoiceID() {
        return validatedStopoverInvoiceID;
    }

    public String getStopoverInvoiceID() {
        return stopoverInvoiceID;
    }

    public String getUserAccountID() {
        return userAccountID;
    }

    public Timestamp getActionDate() {
        return actionDate;
    }
}
