package controllers;

import connection.AppConnection;
import etu2011.framework.annotations.Auth;
import etu2011.framework.annotations.HttpParam;
import etu2011.framework.annotations.ModelController;
import etu2011.framework.annotations.Scope;
import etu2011.framework.annotations.UrlMapping;
import etu2011.framework.enumerations.HttpMethods;
import etu2011.framework.enumerations.HttpParameters;
import etu2011.framework.enumerations.Scopes;
import etu2011.framework.renderer.ModelView;
import models.Service;
import orm.database.connection.DatabaseConnection;

@ModelController(route = "/services")
@Scope(Scopes.SINGLETON)
public class ServiceController {

    @Auth
    @UrlMapping(url = "/new", method = HttpMethods.POST)
    public ModelView newService(@HttpParam(type = HttpParameters.REQUEST_PARAMETER) String name) throws Exception {
        DatabaseConnection connection = new AppConnection().defaultConnection();
        try {
            Service service = new Service();
            service.setName(name);
            service.create(connection);
            connection.commit();
            connection.close();

            return new IndexController().page("services");
        } catch (Exception e) {
            connection.close();
            throw e;
        }
    }
}
