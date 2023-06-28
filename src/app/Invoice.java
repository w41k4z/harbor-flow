package app;

import java.util.ArrayList;

public class Invoice {
    private ArrayList<InvoiceDetails> invoiceDetails;

    public Invoice() {
    }

    public Invoice(ArrayList<InvoiceDetails> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public void setInvoiceDetails(ArrayList<InvoiceDetails> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public ArrayList<InvoiceDetails> getInvoiceDetails() {
        return this.invoiceDetails;
    }

    public Double[] getTotal() {
        Double[] amounts = new Double[] { 0., 0. };
        for (InvoiceDetails invoiceDetail : this.invoiceDetails) {
            amounts[0] += invoiceDetail.getTotal()[0];
            amounts[1] += invoiceDetail.getTotal()[1];
        }
        return amounts;
    }
}
