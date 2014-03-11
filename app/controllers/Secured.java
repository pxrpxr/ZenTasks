package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;

import models.*;

public class Secured extends Security.Authenticator {
  @Override
  public String getUsername(Context ctx) {
    return ctx.session().get("email");
  }

  @Override
  public Result onUnauthorized(Context ctx) {
    Logger.error("UNAUTHORIZED: " + ctx);
    Logger.error("LOGIN ROUTE: " + routes.Application.login());
    return redirect(routes.Application.login());
  }
}
