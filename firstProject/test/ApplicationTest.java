package controllers;

import java.util.List;
import models.Parent;
import play.db.ebean.Model.Finder;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

    public static Result index() {

        // 現在のParentを全検索して表示
        Finder<Long, Parent> finder = new Finder<Long, Parent>(Long.class,
                Parent.class);
        List<Parent> parents = finder.all();

        return ok(index.render(parents));
    }
}