package ua.com.danit.controller;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class UsersServlet extends HttpServlet {
    private final TemplateEngine templateEngine;

    public UsersServlet(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> params = Map.of(
                "users", List.of("Alex", "Diana")
        );
        templateEngine.render("users.ftl", params, response);
    }
}
