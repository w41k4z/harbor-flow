package models;

import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.connection.DatabaseConnection;
import orm.database.object.relation.Relation;

@Table(name = "dock_service", columnCount = 3)
public class DockService extends Relation<DockService> {
    /* FIELDS SECTION */
    @PrimaryKey(column = @Column(name = "id"), prefix = "DKS", length = 8, sequence = "dock_service_sequence")
    private String dockServiceID;

    @Column(name = "dock_id")
    private String dockID;

    @Column(name = "service_id")
    private String serviceID;

    private Service service;

    // service price per category
    private DockServicePrice[] dockServicePrices;

    /* CONSTRUCTOR SECTION */
    public DockService() throws Exception {
        super();
    }

    /* SETTERS SECTION */
    public void setDockServiceID(String dockServiceID) {
        this.dockServiceID = dockServiceID;
    }

    public void setDockID(String dockID) {
        this.dockID = dockID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setDockServicePrices(DockServicePrice[] dockServicePrices) {
        this.dockServicePrices = dockServicePrices;
    }

    /* GETTERS SECTION */
    public String getDockServiceID() {
        return this.dockServiceID;
    }

    public String getDockID() {
        return this.dockID;
    }

    public String getServiceID() {
        return this.serviceID;
    }

    public Service getService() {
        return this.service;
    }

    public DockServicePrice[] getDockServicePrices() {
        return this.dockServicePrices;
    }

    /* OVERRIDES SECTION */
    @Override
    public DockService[] findAll(DatabaseConnection connection) throws Exception {
        DockService[] dockServices = super.findAll(connection);
        for (DockService dockService : dockServices) {
            dockService.setService(new Service().findByPrimaryKey(connection, dockService.getServiceID()));
            dockService.setDockServicePrices(new DockServicePrice().findAll(connection,
                    "dock_service_id = '" + dockService.getDockServiceID() + "'"));
        }
        return dockServices;
    }

    @Override
    public DockService[] findAll(DatabaseConnection connection, String spec) throws Exception {
        DockService[] dockServices = super.findAll(connection, spec);
        for (DockService dockService : dockServices) {
            dockService.setService(new Service().findByPrimaryKey(connection, dockService.getServiceID()));
            dockService.setDockServicePrices(new DockServicePrice().findAll(connection,
                    "dock_service_id = '" + dockService.getDockServiceID() + "'"));
        }
        return dockServices;
    }
}
