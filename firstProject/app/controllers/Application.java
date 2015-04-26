package controllers;

import java.util.List;

import models.Parent;
import play.db.ebean.Model.Finder;
import play.mvc.Controller;
import play.mvc.Result;

import com.avaje.ebean.Query;

public class Application extends Controller {

    public static Result index() {

        // 検索クラス
        Finder<Long, Parent> finder = new Finder<Long, Parent>(Long.class,
                Parent.class);

        // parent1 の取得（条件を指定した検索）
        Query<Parent> query = finder.where("name='新宿太郎'");
        Parent parent1 =query.findUnique();

        // parent2 の取得（Idからの検索。Idは保存したときに振られたId）
        Parent parent2 =finder.byId(new Long(2));

        // 1番目の名前を更新します
        parent1.name = "新宿次郎";
        parent1.update();

        // 2番目を削除します
        parent2.delete();



        // 現在のParentを全検索して表示
        finder = new Finder<Long, Parent>(Long.class,
                Parent.class);
        List<Parent> parents = finder.all();

        StringBuilder msg = new StringBuilder();
        for (Parent parent : parents) {
            msg.append(parent.toString()).append("\n");
        }
        return ok(msg.toString());
    }
}