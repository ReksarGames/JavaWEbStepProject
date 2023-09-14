package Tinder.servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class HelloWorldServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String param = request.getParameter("param");
        String param2 = request.getParameter("param2");
        Map<String, String[]> parameterMap = request.getParameterMap();

        response.setContentType("/text/html");
        response.getWriter().println(String.format("<h2>Hello serv: %s %s </h2>", param, param2));
    }
}
