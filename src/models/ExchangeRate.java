package models;

import java.sql.Timestamp;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.connection.DatabaseConnection;
import orm.database.object.relation.Relation;

@Table(name = "exchange_rate", columnCount = 5)
public class ExchangeRate extends Relation<ExchangeRate> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "ER", length = 7, sequence = "exchange_rate_sequence")
    private String exchangeRateID;

    @Column(name = "change_date")
    private Timestamp date;

    @Column(name = "currency_1")
    private String currency1;

    @Column(name = "currency_2")
    private String currency2;

    @Column
    private Double value;

    /* CONSTRUCTOR SECTION */
    public ExchangeRate() throws Exception {
        super();
    }

    /* SETTERS SECTION */
    public void setExchangeRateID(String exchangeRateID) {
        this.exchangeRateID = exchangeRateID;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setCurrency1(String currency1) {
        this.currency1 = currency1;
    }

    public void setCurrency2(String currency2) {
        this.currency2 = currency2;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    /* GETTERS SECTION */
    public String getExchangeRateID() {
        return this.exchangeRateID;
    }

    public Timestamp getDate() {
        return this.date;
    }

    public String getCurrency1() {
        return this.currency1;
    }

    public String getCurrency2() {
        return this.currency2;
    }

    public Double getValue() {
        return this.value;
    }

    /* METHODS SECTION */
    public static ExchangeRate getLatestExchangeRate(DatabaseConnection connection, String currency1, String currency2,
            Timestamp date) throws Exception {
        ExchangeRate exchangeRate = new ExchangeRate().findAll(connection,
                "WHERE ((currency_1 = '" + currency1 + "' AND currency_2 = '" + currency2 + "') OR (currency_1 = '"
                        + currency2 + "' AND currency_2 = '" + currency1 + "')) AND change_date <= "
                        + connection.timeStampFormat(date.toString()) + " ORDER BY change_date")[0];
        return exchangeRate;
    }
}
