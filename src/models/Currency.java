package models;

import orm.database.connection.DatabaseConnection;
import orm.database.object.relation.Relation;

import java.sql.Timestamp;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;

@Table(columnCount = 2)
public class Currency extends Relation<Currency> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "CUR", length = 7, sequence = "currency_sequence")
    private String currencyID;

    @Column
    private String label;

    private Double value;

    /* CONSTRUCTOR SECTION */
    public Currency() throws Exception {
        super();
    }

    /* SETTERS SECTION */
    public void setCurrencyID(String currencyID) {
        this.currencyID = currencyID;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    /* GETTERS SECTION */
    public String getCurrencyID() {
        return this.currencyID;
    }

    public String getLabel() {
        return this.label;
    }

    public Double getValue() {
        return this.value;
    }

    /* METHODS SECTION */
    public double getConversionTo(DatabaseConnection connection, String currency_id, Timestamp date) throws Exception {
        ExchangeRate latestEchangeRate = ExchangeRate.getLatestExchangeRate(connection, this.getCurrencyID(),
                currency_id, date);
        if (latestEchangeRate.getCurrency1().equals(this.getCurrencyID())) {
            return latestEchangeRate.getValue() * this.getValue();
        } else if (latestEchangeRate.getCurrency2().equals(this.getCurrencyID())) {
            return this.getValue() / latestEchangeRate.getValue();
        } else {
            throw new Exception("Currency not found");
        }
    }
}
