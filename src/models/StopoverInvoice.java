package models;

import java.sql.Timestamp;
import java.util.ArrayList;

import app.Invoice;
import app.InvoiceDetails;
import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.connection.DatabaseConnection;
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

    @Column(name = "state")
    private Integer status;

    private Stopover stopover;

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

    public void setStatus(Integer state) {
        this.status = state;
    }

    public void setStopover(Stopover stopover) {
        this.stopover = stopover;
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

    public Integer getStatus() {
        return status;
    }

    public String getActualStatus() {
        switch (status) {
            case 1:
                return "Pending";
            case 11:
                return "Validated";
            case 21:
                return "Paid";
            default:
                return "None";
        }
    }

    public Stopover getStopover() {
        return this.stopover;
    }

    /* METHODS SECTION */
    public Invoice getFacture(DatabaseConnection connection) throws Exception {
        Boats boat = this.getStopover().getBoat();
        Double[] totalAmount = new Double[2];
        totalAmount[0] = 0.;
        totalAmount[1] = 0.;
        ArrayList<InvoiceDetails> details = new ArrayList<InvoiceDetails>();
        for (StopoverServices stopoverService : this.stopover.getStopoverServices()) {
            InvoiceDetails invoiceDetails = new InvoiceDetails();
            invoiceDetails.setDock(stopoverService.getDock());
            ArrayList<StopoverServicesDetails> stopoverServicesDetails = new ArrayList<StopoverServicesDetails>();
            ArrayList<Double[]> amounts = new ArrayList<Double[]>();
            // System.out.println(stopoverService.getDockID());
            for (StopoverServicesDetails stopoverServiceDetail : stopoverService.getStopoverServicesDetails()) {
                if (stopoverServiceDetail.getState() >= 11 && stopoverServiceDetail.getState() < 21) {
                    stopoverServicesDetails.add(stopoverServiceDetail);
                    amounts.add(stopoverServiceDetail.getCost(boat));
                }
            }
            invoiceDetails.setServices(stopoverServicesDetails);
            invoiceDetails.setAmounts(amounts);
            details.add(invoiceDetails);
            // for (Double[] amounts : stopoverService.getInvoice(connection, boat)) {
            // totalAmount[0] += amounts[0];
            // totalAmount[1] += amounts[1];
            // }
        }
        return new Invoice(details);
    }

    /* OVERRIDES SECTION */
    @Override
    public StopoverInvoice[] findAll(DatabaseConnection connection) throws Exception {
        StopoverInvoice[] stopoverInvoices = super.findAll(connection);
        for (StopoverInvoice stopoverInvoice : stopoverInvoices) {
            stopoverInvoice.setStopover(new Stopover().findByPrimaryKey(connection, stopoverInvoice.getStopoverID()));
        }
        return stopoverInvoices;
    }

    @Override
    public StopoverInvoice[] findAll(DatabaseConnection connection, String spec) throws Exception {
        StopoverInvoice[] stopoverInvoices = super.findAll(connection, spec);
        for (StopoverInvoice stopoverInvoice : stopoverInvoices) {
            stopoverInvoice.setStopover(new Stopover().findByPrimaryKey(connection, stopoverInvoice.getStopoverID()));
        }
        return stopoverInvoices;
    }

    @Override
    public StopoverInvoice findByPrimaryKey(DatabaseConnection connection) throws Exception {
        StopoverInvoice stopoverInvoice = super.findByPrimaryKey(connection);
        stopoverInvoice.setStopover(new Stopover().findByPrimaryKey(connection, stopoverInvoice.getStopoverID()));
        return stopoverInvoice;
    }

    @Override
    public StopoverInvoice findByPrimaryKey(DatabaseConnection connection, String spec) throws Exception {
        StopoverInvoice stopoverInvoice = super.findByPrimaryKey(connection, spec);
        stopoverInvoice.setStopover(new Stopover().findByPrimaryKey(connection, stopoverInvoice.getStopoverID()));
        return stopoverInvoice;
    }
}
