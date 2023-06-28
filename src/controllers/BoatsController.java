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

import models.Boat;
import models.BoatCategory;
import models.BoatFlag;
import orm.database.connection.DatabaseConnection;

@ModelController(route = "/boats")
@Scope(Scopes.SINGLETON)
public class BoatsController {

    @Auth
    @UrlMapping(url = "/new", method = HttpMethods.POST)
    public ModelView newBoat(
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String name,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String type,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) Double length,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) Double width,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) Double depth,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) Double weight,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) Double towing,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String flag,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String currency) throws Exception {

        DatabaseConnection connection = new AppConnection().defaultConnection();
        try {
            Boat boat = new Boat();
            boat.setName(name);
            boat.setTypeID(type);
            boat.setLength(length);
            boat.setWidth(width);
            boat.setDepth(depth);
            boat.setWeight(weight);
            boat.setTowing(towing);
            boat.setFlagID(flag);
            boat.setCurrencyID(currency);
            boat.create(connection);

            connection.commit();
            connection.close();

            return new IndexController().page("boats");
        } catch (Exception e) {
            connection.close();
            throw e;
        }

    }

    @Auth
    @UrlMapping(url = "/category/new", method = HttpMethods.POST)
    public ModelView newCategory(@HttpParam(type = HttpParameters.REQUEST_PARAMETER) String name) throws Exception {
        DatabaseConnection connection = new AppConnection().defaultConnection();
        try {
            BoatCategory boatCategory = new BoatCategory();
            boatCategory.setName(name);
            boatCategory.create(connection);
            connection.commit();
            connection.close();

            return new IndexController().page("boatcategories");
        } catch (Exception e) {
            connection.close();
            throw e;
        }
    }

    @Auth
    @UrlMapping(url = "/flag/new", method = HttpMethods.POST)
    public ModelView newFlag(@HttpParam(type = HttpParameters.REQUEST_PARAMETER) String origin) throws Exception {
        DatabaseConnection connection = new AppConnection().defaultConnection();
        try {
            BoatFlag boatFlag = new BoatFlag();
            boatFlag.setOrigin(origin);
            boatFlag.create(connection);
            connection.commit();
            connection.close();

            return new IndexController().page("boatflags");
        } catch (Exception e) {
            connection.close();
            throw e;
        }
    }
}
