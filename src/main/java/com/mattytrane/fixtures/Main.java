package com.mattytrane.fixtures;

import com.mattytrane.fixtures.model.SimpleTeamDAO;
import com.mattytrane.fixtures.model.Team;
import com.mattytrane.fixtures.model.TeamDAO;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");
        TeamDAO dao = new SimpleTeamDAO();

        before((req, res) -> {
            if (req.cookie("username") != null) {
                req.attribute("username", req.attribute("username"));
            }
        });

        before("/fixture", (req, res) -> {
            if (req.attribute("username") == null) {
                res.redirect("/");
                halt();
            }
        });

        get("/", (req, res) -> {
            Map<String, String> model = new HashMap<>();
            model.put("username", req.attribute("username"));
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("teams", dao.findAll());
            model.put("username", req.queryParams("username"));

            return new ModelAndView(model, "teams.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/:slug/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("team", dao.findBySlug(req.params("slug")));
            return new ModelAndView(model, "team.hbs");
        }, new HandlebarsTemplateEngine());


        get("/spurs", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Team spurs = Team.generateSpursTeam();
            model.put("username", req.queryParams("username"));
            model.put("manager", dao.getManager(spurs));
            model.put("names", dao.getPlayers(spurs));
            model.put("teamName", dao.getTeamName(spurs));
            return new ModelAndView(model, "spurs.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:slug/like", (req, res) -> {

            Team team = dao.findBySlug(req.queryParams("slug"));
            res.redirect("/teams");
            return null;
        });

        post("/sign-in", (req, res) -> {
            Map<String, String> model = new HashMap<>();
            model.put("username", req.queryParams("username"));
            return new ModelAndView(model, "sign-in.hbs");
        }, new HandlebarsTemplateEngine());

        exception(NotFound.class, (exc, req, res) -> {
            res.status(404);
            HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
            String html = engine.render(
                    new ModelAndView(null, "not-found.hbs"));
            res.body(html);
        });

    } //main
} //class