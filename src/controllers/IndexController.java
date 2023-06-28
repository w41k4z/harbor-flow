package controllers;

import models.BoatCategory;
import models.BoatFlag;
import models.Boats;
import models.Currency;
import models.Docks;
import models.Service;
import connection.AppConnection;

import etu2011.framework.annotations.Auth;
import etu2011.framework.annotations.HttpParam;
import etu2011.framework.annotations.ModelController;
import etu2011.framework.annotations.Scope;
import etu2011.framework.annotations.UrlMapping;
import etu2011.framework.enumerations.HttpParameters;
import etu2011.framework.enumerations.Scopes;
import etu2011.framework.renderer.ModelView;

import orm.database.connection.DatabaseConnection;

@ModelController
@Scope(Scopes.SINGLETON)
public class IndexController {

    @UrlMapping(url = "/")
    public ModelView index() {
        return new ModelView("login/logIn.jsp");
    }

    @Auth
    @UrlMapping(url = "/page/{page}")
    public ModelView page(@HttpParam(type = HttpParameters.PATH_VARIABLE) String page) throws Exception {
        DatabaseConnection connection = new AppConnection().defaultConnection();
        ModelView modelView = new ModelView("admin/" + page + ".jsp");

        Boats[] allBoats = new Boats().findAll(connection);
        BoatCategory[] allBoatCategories = new BoatCategory().findAll(connection);
        BoatFlag[] allBoatFlags = new BoatFlag().findAll(connection);
        Currency[] allCurrencies = new Currency().findAll(connection);
        Docks[] allDocks = new Docks().findAll(connection);
        Service[] allServices = new Service().findAll(connection);

        modelView.addData("allBoats", allBoats);
        modelView.addData("allBoatCategories", allBoatCategories);
        modelView.addData("allBoatFlags", allBoatFlags);
        modelView.addData("allCurrencies", allCurrencies);
        modelView.addData("allDocks", allDocks);
        modelView.addData("allServices", allServices);

        connection.close();
        return modelView;
    }
}
