package ua.com.danit.dao;

import ua.com.danit.domain.Country;
import ua.com.danit.domain.Department;
import ua.com.danit.domain.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcEmployeeDao implements EmployeeDao{
    @Override
    public List<Employee> findAll() {
        List<Employee> allEmployees = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT e.employee_id, d.department_name, e.first_name\n" +
                    "FROM employees e JOIN departments d  USING (department_id)");

            while (resultSet.next()) {

                Long employeeId = resultSet.getLong("employee_id");
                String departmentName = resultSet.getString("department_name");
                String firstName = resultSet.getString("first_name");

                allEmployees.add(new Employee(employeeId, firstName, new Department(departmentName)));

            }

        } catch (SQLException e){
            System.out.println("Something went wrong, with db interaction returning employees");
            e.printStackTrace();
        }

        return allEmployees;
    }

    @Override
    public Optional<Employee> findById(int id) {
        return Optional.empty();
    }
}
