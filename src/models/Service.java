package models;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.object.relation.Relation;

@Table(name = "service", columnCount = 2)
public class Service extends Relation<Service> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "SRV", length = 7, sequence = "service_sequence")
    private String serviceID;

    @Column
    private String name;

    /* CONSTRUCTOR SECTION */
    public Service() throws Exception {
        super();
    }

    /* SETTERS SECTION */
    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* GETTERS SECTION */
    public String getServiceID() {
        return this.serviceID;
    }

    public String getName() {
        return this.name;
    }

}
