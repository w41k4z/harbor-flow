package models;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.object.relation.Relation;

@Table(name = "source", columnCount = 2)
public class Source extends Relation<Source> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "SRC", length = 7, sequence = "source_sequence")
    private String sourceID;

    @Column
    private String ip;

    /* CONSTRUCTOR SECTION */
    public Source() throws Exception {
        super();
    }

    /* SETTERS SECTION */
    public void setSourceID(String sourceID) {
        this.sourceID = sourceID;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    /* GETTERS SECTION */
    public String getSourceID() {
        return this.sourceID;
    }

    public String getIp() {
        return this.ip;
    }
}
