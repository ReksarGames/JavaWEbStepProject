package Tinder.servlets;


import Tinder.controller.TemplateEngine;
import Tinder.dao.UserProfileDAO;
import Tinder.model.UserProfile;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {
    private UserProfileDAO userProfileDAO;
    private final TemplateEngine fm = TemplateEngine.resources("/template");


    @Override
    public void init() throws ServletException {
        super.init();
        userProfileDAO = new UserProfileDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Users Servet");
        List<UserProfile> profiles = userProfileDAO.getAllProfiles();
        request.setAttribute("profiles", profiles);
        System.out.println("Users Servlet"); //TODO: Убрать после
        fm.render("/profile/index.html", new HashMap<>(1), response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int profileId = Integer.parseInt(request.getParameter("profileId"));
        String choice = request.getParameter("choice");

        //Сохранение выбора пользователя в ДБ
        userProfileDAO.saveUserChoice(profileId, choice);

        response.sendRedirect(request.getContextPath() + "/users");

    }
}
