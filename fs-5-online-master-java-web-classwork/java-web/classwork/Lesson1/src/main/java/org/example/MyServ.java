package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyServ extends HttpServlet {
    Map<String, String> auth = Map.of(
            "admin", "admin",
            "guest","guest",
            "1","1"
    );

    @Override
    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("""
                <form action="/" method="POST" >
                    <label>Login</label>
                    <input type="text" name="login" value="1" />
                    </br>
                    <label>Password</label>
                    <input type="password" name="password" value="1" />
                    </br>
                    <button type="submit">Submit</button>
                </form>
                """);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String pass = auth.get(login);
        if (password != null && pass != null && password.equals(pass)){
            resp.getWriter().println(login + " " + password);
        } else {
            resp.getWriter().println("Not Success");
        }
    }
}
