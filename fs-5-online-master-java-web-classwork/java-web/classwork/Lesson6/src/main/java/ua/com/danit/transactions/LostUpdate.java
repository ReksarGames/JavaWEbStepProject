package ua.com.danit.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LostUpdate {
    public static void main(String[] args) {
        new Thread(() -> {
            try (Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
                connection.setAutoCommit(false);
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE employees SET balance = balance - 20 WHERE employee_id = 100");
                int res = statement.executeUpdate();
                Thread.sleep(1000);
                connection.commit();
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try (Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
                connection.setAutoCommit(false);
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE employees SET balance = balance - 10 WHERE employee_id = 100");
                int res = statement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
