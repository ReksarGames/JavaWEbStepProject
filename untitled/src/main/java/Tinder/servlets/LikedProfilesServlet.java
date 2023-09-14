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

@WebServlet("/liked")
public class LikedProfilesServlet extends HttpServlet {
    private UserProfileDAO userProfileDAO;
    private final TemplateEngine fm = TemplateEngine.resources("/template");


    @Override
    public void init() throws ServletException {
        super.init();
        userProfileDAO = new UserProfileDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserProfile> likedProfiles = userProfileDAO.getLikedProfiles();
        request.setAttribute("likedProfiles", likedProfiles);

        System.out.println("Liked Servlet"); //TODO: Убрать после
        fm.render("liked.jsp", new HashMap<>(1), response);

    }
}
