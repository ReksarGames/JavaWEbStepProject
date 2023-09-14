package ua.com.danit;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ua.com.danit.controller.*;
import ua.com.danit.dao.CountryDao;
import ua.com.danit.dao.JdbcCountryDao;
import ua.com.danit.service.CountryService;
import ua.com.danit.service.DefaultCountryService;

public class JettyRun {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        TemplateEngine templateEngine = new TemplateEngine();
        CountryDao countryDao = new JdbcCountryDao();
        CountryService countryService = new DefaultCountryService(countryDao);

        ServletContextHandler handler = new ServletContextHandler();
        HelloServlet helloServlet = new HelloServlet(templateEngine);
        IndexServlet indexServlet = new IndexServlet(templateEngine);
        UsersServlet usersServlet = new UsersServlet(templateEngine);
        CountriesServlet countriesServlet = new CountriesServlet(templateEngine, countryService);
        handler.addServlet(new ServletHolder(indexServlet), "/");
        handler.addServlet(new ServletHolder(helloServlet), "/hello");
        handler.addServlet(new ServletHolder(usersServlet), "/users");
        handler.addServlet(new ServletHolder(countriesServlet), "/countries");
        handler.addServlet(CSSBootstrapServlet.class, "/assets/css/bootstrap.min.css");
        server.setHandler(handler);

        server.start();
        server.join();
    }
}
