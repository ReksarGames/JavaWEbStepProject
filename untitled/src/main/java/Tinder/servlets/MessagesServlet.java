package Tinder.servlets;

import Tinder.controller.TemplateEngine;
import Tinder.dao.MessageDAO;
import Tinder.model.Message;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/messages/*")
public class MessagesServlet extends HttpServlet {
    private MessageDAO messageDAO;
    private final TemplateEngine fm = TemplateEngine.resources("/template");


    @Override
    public void init() throws ServletException {
        super.init();
        messageDAO = new MessageDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        int profileId = parseProfileIdFromPath(request.getPathInfo());
        List<Message> messages = messageDAO.getMessagesBetweenProfiles(1, profileId); // Ваш текущий пользователь (здесь 1)
        request.setAttribute("messages", messages);
        System.out.println("Messages Servlet"); //TODO: Убрать после
        fm.render("messages.jsp", new HashMap<>(1), response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int profileId = parseProfileIdFromPath(request.getPathInfo());
        String content = request.getParameter("content");


        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        Message message = new Message(1, profileId, username, content); // текущий пользователь (здесь 1)
        messageDAO.saveMessage(message);

        response.sendRedirect(request.getRequestURI()); // Остаемся на той же странице
    }

    private int parseProfileIdFromPath(String pathInfo) {
        String[] pathParts = pathInfo.split("/");
        return Integer.parseInt(pathParts[1]); // Второй элемент массива будет id
    }


}
