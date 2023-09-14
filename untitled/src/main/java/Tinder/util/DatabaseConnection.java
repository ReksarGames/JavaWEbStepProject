package Tinder.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/?user=root";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(url, username, password);
    }
}
