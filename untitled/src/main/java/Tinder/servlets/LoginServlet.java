package Tinder.servlets;

import Tinder.controller.TemplateEngine;
import Tinder.dao.UserProfileDAO;
import Tinder.util.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class LoginServlet extends HttpServlet {
    private UserProfileDAO userProfileDAO;
    private final TemplateEngine fm = TemplateEngine.resources("/template");
    @Override
    public void init() throws ServletException {
        super.init();
        userProfileDAO = new UserProfileDAO(); // Инициализация DAO при инициализации сервлета
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Login Servlet");
        fm.render("login.jsp", new HashMap<>(1), response);

    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        fm.render("login.ftl", new HashMap<>(1), resp);
//    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        // Реализуйте проверку пользователя в базе данных
        if (isValidUser(username)) {
            request.getSession().setAttribute("username", username);
            response.sendRedirect(request.getContextPath() + "/users");
        } else {
            request.setAttribute("error", "Invalid username");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    private boolean isValidUser(String username) {
        return userProfileDAO.getAllProfiles() != null;

    }

}
