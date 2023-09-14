package org.example;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Main {
    public static void main(String[] args) throws Exception {

        String portVal = System.getProperty("PORT") == null ? "8081" : System.getenv("PORT");
        Server server = new Server(Integer.parseInt(portVal));

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(MyServ.class,    "/");
//        handler.addServlet(Servlet2.class, "/servlet2");
        server.setHandler(handler);

        server.start();
        server.join();

        // Написать сервлет аутентификации
    }
}