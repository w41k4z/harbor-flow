package controllers;

import etu2011.framework.annotations.HttpParam;
import etu2011.framework.annotations.ModelController;
import etu2011.framework.annotations.Scope;
import etu2011.framework.annotations.UrlMapping;
import etu2011.framework.enumerations.HttpMethods;
import etu2011.framework.enumerations.HttpParameters;
import etu2011.framework.enumerations.Scopes;
import etu2011.framework.renderer.ModelView;
import models.UserAccount;

@ModelController(route = "/login")
@Scope(Scopes.PROTOTYPE)
public class LogInController {

    @UrlMapping(url = "")
    public ModelView index() {
        return new ModelView("login/logIn.jsp");
    }

    @UrlMapping(url = "/authenticate", method = HttpMethods.POST)
    public ModelView authenticate(
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String email,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String password) {

        ModelView view;
        try {
            // do not forget this
            Class.forName("org.postgresql.Driver");

            UserAccount userAccount = UserAccount.authenticate(email, password);
            view = new ModelView("home/stopover.jsp");
            view.addSession("user", userAccount.getUserAccountID());
            view.addSession("profile", userAccount.getProfile());
        } catch (Exception e) {
            view = new ModelView("error.jsp");
            view.addData("error", e);
        }
        return view;

    }
}
