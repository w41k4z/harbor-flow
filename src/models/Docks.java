package models;

import java.util.ArrayList;

import app.Proforma;

import orm.annotation.Column;
import orm.annotation.Table;
import orm.database.connection.DatabaseConnection;
import orm.database.object.relation.Relation;
import orm.database.object.view.View;

@Table(columnCount = 5)
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

    public DockService[] getDockServices() {
        return this.dockServices;
    }

    /* METHODS SECTION */
    public ArrayList<Services> getServicesFrom(Proforma proforma) throws Exception {
        ArrayList<Services> services = new ArrayList<>();
        for (String prestation : proforma.getPrestations()) {
            boolean notFound = true;
            for (DockService dockService : this.dockServices) {
                if (dockService.getService().getName().toLowerCase().equals(prestation.toLowerCase())) {
                    notFound = false;
                    services.add(dockService.getService());
                    break;
                }
            }
            if (notFound) {
                throw new Exception("This dock do not have this prestation: '" + prestation + "'");
            }
        }
        return services;
    }

    public double estimateTotalCost(Proforma proforma) {
        ArrayList<Services> services = this.getServicesFrom(proforma);
        double totalCost = 0;
        for (DockService dockService : this.dockServices) {
            totalCost += dockService.getCost();
        }
        return totalCost;
    }

    /* OVERRIDES SECTION */
    @Override
    public Docks[] findAll(DatabaseConnection connection) throws Exception {
        Docks[] docks = new View<Docks>("docks", Docks.class).findAll(connection);
        for (Docks dock : docks) {
            dock.setDockServices(new DockService().findAll(connection,
                    "WHERE dock_id = '" + dock.getDockID()));
        }
        return docks;
    }

    @Override
    public Docks[] findAll(DatabaseConnection connection, String spec) throws Exception {
        Docks[] docks = new View<Docks>("docks", Docks.class).findAll(connection, spec);
        for (Docks dock : docks) {
            dock.setDockServices(new DockService().findAll(connection,
                    "WHERE dock_id = '" + dock.getDockID()));
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
