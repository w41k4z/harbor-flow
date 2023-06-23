package models;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;

@Table(name = "stopover_invoice_details", columnCount = 3)
public class StopoverInvoiceDetails {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "STID", length = 9, sequence = "stopover_invoice_details_sequence")
    private String stopoverInvoiceDetailsID;

    @Column(name = "stopover_invoice_id")
    private String stopoverInvoiceID;

    @Column(name = "validated_stopover_service_id")
    private String validatedStopoverServiceID;

    /* CONSTRUCTOR SECTION */
    public StopoverInvoiceDetails() throws Exception {
        super();
    }

    /* SETTERS */
    public void setStopoverInvoiceDetailsID(String stopoverInvoiceDetailsID) {
        this.stopoverInvoiceDetailsID = stopoverInvoiceDetailsID;
    }

    public void setStopoverInvoiceID(String stopoverInvoiceID) {
        this.stopoverInvoiceID = stopoverInvoiceID;
    }

    public void setValidatedStopoverServiceID(String validatedStopoverServiceID) {
        this.validatedStopoverServiceID = validatedStopoverServiceID;
    }

    /* GETTERS */
    public String getStopoverInvoiceDetailsID() {
        return stopoverInvoiceDetailsID;
    }

    public String getStopoverInvoiceID() {
        return stopoverInvoiceID;
    }

    public String getValidatedStopoverServiceID() {
        return validatedStopoverServiceID;
    }
}
