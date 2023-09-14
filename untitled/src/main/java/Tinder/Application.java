package Tinder;

import Tinder.servlets.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.server.handler.ResourceHandler;


public class Application {
    public static void main(String[] args) throws Exception {
        int port = 8080; // Порт, на котором будет запущен сервер

        // Создание HTTP-сервера с Jetty
        Server server = new Server(port);

        // Создание обработчика статических ресурсов
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[] { "index.html" });
        resourceHandler.setResourceBase("./src/main/resources"); // Замените путь на ваш путь к ресурсам

        // Создание контекста приложения
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setContextPath("/");

        // Создание экземпляров сервлетов
        UsersServlet usersServlet = new UsersServlet();
        MessagesServlet messagesServlet = new MessagesServlet();
        LoginServlet loginServlet = new LoginServlet();
        LikedProfilesServlet likedProfilesServlet = new LikedProfilesServlet();

        // Регистрация сервлетов
        contextHandler.addServlet(new ServletHolder(usersServlet), "/users");
        contextHandler.addServlet(new ServletHolder(messagesServlet), "/messages/*");
        contextHandler.addServlet(new ServletHolder(loginServlet), "/login");
        contextHandler.addServlet(new ServletHolder(likedProfilesServlet), "/liked");

        // Подключение контекста приложения к серверу
        server.setHandler(contextHandler);

        // Запуск сервера
        server.start();
        server.join();
    }
}
