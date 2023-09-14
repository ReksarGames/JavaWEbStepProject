package ua.com.danit.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhantomeRead {
    public static void main(String[] args) {
        new Thread(() -> {
            try (Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
                System.out.println(getTotalBalance(connection));
                Thread.sleep(1000);
                System.out.println(getTotalBalance(connection));
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try (Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
                connection.setAutoCommit(false);
                PreparedStatement statement = connection.prepareStatement(
                        """
                                INSERT INTO employees (last_name, email, hire_date, job_id, balance)  
                                VALUES ('Van', 'Du', current_date, 'SA_REP', 100);                               
                                """);
                int res = statement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static double getTotalBalance(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT SUM(balance) FROM employees");
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet.getDouble(1);
    }
}
