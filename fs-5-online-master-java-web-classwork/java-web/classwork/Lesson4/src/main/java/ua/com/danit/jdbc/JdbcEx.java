package ua.com.danit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

public class JdbcEx {
    public static void main(String[] args) throws SQLException {
        /*
            1. Driver JDBC
            2. DriverManager
            3. Connection
                jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres
            4. Statement
            5. ResultSet
         */
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees WHERE employee_id = ?");
            statement.setLong(1, 100L);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int employeeId = resultSet.getInt("employee_id");
            String firstName = resultSet.getString("first_name");
            System.out.printf("%d \t %s", employeeId, firstName);
        }

    }
}
