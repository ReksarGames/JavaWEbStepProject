package ua.com.danit;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ua.com.danit.controller.CSSBootstrapServlet;
import ua.com.danit.controller.HelloServlet;
import ua.com.danit.controller.IndexServlet;
import ua.com.danit.controller.TemplateEngine;
import ua.com.danit.controller.UsersServlet;

public class JettyRun {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        TemplateEngine templateEngine = new TemplateEngine();

        ServletContextHandler handler = new ServletContextHandler();
        HelloServlet helloServlet = new HelloServlet(templateEngine);
        IndexServlet indexServlet = new IndexServlet(templateEngine);
        UsersServlet usersServlet = new UsersServlet(templateEngine);
        handler.addServlet(new ServletHolder(indexServlet), "/");
        handler.addServlet(new ServletHolder(helloServlet), "/hello");
        handler.addServlet(new ServletHolder(usersServlet), "/users");
        handler.addServlet(CSSBootstrapServlet.class, "/assets/css/bootstrap.min.css");
        server.setHandler(handler);

        server.start();
        server.join();
    }
}
