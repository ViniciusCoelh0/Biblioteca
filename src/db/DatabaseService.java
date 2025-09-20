package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    private static final String url = "jdbc:sqlite:biblioteca.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url);
    }
}
