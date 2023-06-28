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
@Scope(Scopes.SINGLETON)
public class LogInController {

    @UrlMapping(url = "/authenticate", method = HttpMethods.POST)
    public ModelView authenticate(
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String email,
            @HttpParam(type = HttpParameters.REQUEST_PARAMETER) String password) throws Exception {

        ModelView view;
        try {
            UserAccount userAccount = UserAccount.authenticate(email, password);
            // redirection
            view = new IndexController().page("boats");
            view.addSession("user", userAccount.getUserAccountID());
            view.addSession("profile", userAccount.getProfile());
        } catch (Exception e) {
            view = new ModelView("error.jsp");
            view.addData("error", e);
        }
        return view;
    }

}
