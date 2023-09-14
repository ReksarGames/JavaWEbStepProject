package ua.com.danit.controller;

import ua.com.danit.service.EmployeeService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class EmployeeServlet extends HttpServlet {
    private final TemplateEngine templateEngine;
    private final EmployeeService employeeService;

    public EmployeeServlet(TemplateEngine templateEngine, EmployeeService employeeService) {
        this.templateEngine = templateEngine;
        this.employeeService = employeeService;

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> params = Map.of(
                "employees", employeeService.findAll()
        );
        templateEngine.render("employees.ftl", params, response);
    }

}
