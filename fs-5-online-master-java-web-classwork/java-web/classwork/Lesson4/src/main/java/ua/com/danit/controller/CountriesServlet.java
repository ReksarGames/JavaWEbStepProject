package ua.com.danit.controller;

import ua.com.danit.dao.JdbcCountryDao;
import ua.com.danit.service.CountryService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class CountriesServlet extends HttpServlet {
    private final TemplateEngine templateEngine;
    private final CountryService countryService;

    public CountriesServlet(TemplateEngine templateEngine, CountryService countryService) {
        this.templateEngine = templateEngine;
        this.countryService = countryService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, Object> params = Map.of(
                "countries", countryService.findAll()
        );
        templateEngine.render("countries.ftl", params, resp);
    }
}
