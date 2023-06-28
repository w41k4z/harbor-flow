package models;

import java.util.ArrayList;

import app.Proforma;

import orm.annotation.Column;
import orm.annotation.Table;
import orm.database.connection.DatabaseConnection;
import orm.database.object.relation.Relation;
import orm.database.object.view.View;

@Table(columnCount = 6)
public class Docks extends Relation<Docks> {
    /* FIELDS SECTION */
    @Column(name = "id")
    private String dockID;

    @Column
    private String name;

    @Column
    private Double length;

    @Column
    private Double width;

    @Column
    private Double depth;

    @Column
    private String currency;

    private DockService[] dockServices;

    /* CONSTRUCTOR SECTION */
    public Docks() throws Exception {
        super();
    }

    /* SETTERS SECTION */
    public void setDockID(String dockID) {
        this.dockID = dockID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(Double length) {
        if (length > 0) {
            this.length = length;
        }
    }

    public void setWidth(Double width) {
        if (width > 0) {
            this.width = width;
        }
    }

    public void setDepth(Double depth) {
        if (depth > 0) {
            this.depth = depth;
        }
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setDockServices(DockService[] dockServices) {
        this.dockServices = dockServices;
    }

    /* GETTERS SECTION */
    public String getDockID() {
        return dockID;
    }

    public String getName() {
        return name;
    }

    public Double getLength() {
        return length;
    }

    public Double getWidth() {
        return width;
    }

    public Double getDepth() {
        return depth;
    }

    public String getCurrency() {
        return currency;
    }

    public DockService[] getDockServices() {
        return this.dockServices;
    }

    /* METHODS SECTION */
    public DockService getServiceByName(String name) {
        for (DockService dockService : this.dockServices) {
            if (dockService.getService().getName().toLowerCase().equals(name.toLowerCase())) {
                return dockService;
            }
        }
        return null;
    }

    public ArrayList<DockService> getServicesFrom(Proforma proforma) throws Exception {
        ArrayList<DockService> services = new ArrayList<>();
        for (String prestation : proforma.getPrestations()) {
            boolean notFound = true;
            for (DockService dockService : this.dockServices) {
                if (dockService.getService().getName().toLowerCase().equals(prestation.toLowerCase())) {
                    notFound = false;
                    services.add(dockService);
                    break;
                }
            }
            if (notFound) {
                throw new Exception("This dock do not have this prestation: '" + prestation + "'");
            }
        }
        return services;
    }

    public double estimateTotalCost(Proforma proforma) throws Exception {
        ArrayList<DockService> services = this.getServicesFrom(proforma);
        double totalCost = 0;
        for (DockService dockService : services) {
            double prestationDuration = dockService.getService().getName().equals("remorquage")
                    ? proforma.getBoat().getTowing()
                    : (proforma.getForecastingEndDate().getTime() - proforma.getForecastingStartDate().getTime())
                            / (60 * 1000);
            Double[] estimation = dockService.estimateCost(proforma.getBoat(), prestationDuration);
            totalCost += estimation[0];
        }
        return totalCost;
    }

    /* OVERRIDES SECTION */
    @Override
    public Docks findByPrimaryKey(DatabaseConnection connection) throws Exception {
        Docks[] docks = new View<Docks>("docks", Docks.class).findAll(connection,
                "WHERE id = '" + this.getDockID() + "'");
        if (docks.length == 1) {
            docks[0].setDockServices(new DockService().findAll(connection,
                    "WHERE dock_id = '" + docks[0].getDockID() + "'"));
            return docks[0];
        }
        return null;
    }

    @Override
    public Docks findByPrimaryKey(DatabaseConnection connection, String pk) throws Exception {
        Docks[] docks = new View<Docks>("docks", Docks.class).findAll(connection, "WHERE id = '" + pk + "'");
        if (docks.length == 1) {
            docks[0].setDockServices(new DockService().findAll(connection,
                    "WHERE dock_id = '" + docks[0].getDockID() + "'"));
            return docks[0];
        }
        return null;
    }

    @Override
    public Docks[] findAll(DatabaseConnection connection) throws Exception {
        Docks[] docks = new View<Docks>("docks", Docks.class).findAll(connection);
        for (Docks dock : docks) {
            dock.setDockServices(new DockService().findAll(connection,
                    "WHERE dock_id = '" + dock.getDockID() + "'"));
        }
        return docks;
    }

    @Override
    public Docks[] findAll(DatabaseConnection connection, String spec) throws Exception {
        Docks[] docks = new View<Docks>("docks", Docks.class).findAll(connection, spec);
        for (Docks dock : docks) {
            dock.setDockServices(new DockService().findAll(connection,
                    "WHERE dock_id = '" + dock.getDockID() + "'"));
        }
        return docks;
    }

    @Override
    public int create(DatabaseConnection connection) throws Exception {
        throw new Exception("Not an actual existing table");
    }

    @Override
    public int create(DatabaseConnection connection, String manualPK) throws Exception {
        throw new Exception("Not an actual existing table");
    }

    @Override
    public int update(DatabaseConnection connection) throws Exception {
        throw new Exception("Not an actual existing table");
    }

    @Override
    public int update(DatabaseConnection connection, String spec) throws Exception {
        throw new Exception("Not an actual existing table");
    }

    @Override
    public int delete(DatabaseConnection connection) throws Exception {
        throw new Exception("Not an actual existing table");
    }

    @Override
    public int delete(DatabaseConnection connection, String spec) throws Exception {
        throw new Exception("Not an actual existing table");
    }
}
