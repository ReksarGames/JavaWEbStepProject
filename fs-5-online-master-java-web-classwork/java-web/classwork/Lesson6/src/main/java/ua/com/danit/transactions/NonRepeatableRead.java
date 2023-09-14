package ua.com.danit.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NonRepeatableRead {
    public static void main(String[] args) {
        new Thread(() -> {
            try (Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
                System.out.println(getBalance(connection));
                Thread.sleep(1000);
                System.out.println(getBalance(connection));
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try (Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
                connection.setAutoCommit(false);
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE employees SET balance = balance + 25 WHERE employee_id = 100");
                int res = statement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static double getBalance(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees WHERE employee_id = ?");
        statement.setLong(1, 100L);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet.getDouble("balance");
    }
}
