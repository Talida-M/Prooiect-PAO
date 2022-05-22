package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection connection;

    private Database() {}
    public static Connection getConnection()throws SQLException {
        if (connection == null){
            String url = "jdbc:mysql://localhost:3306/proiect_pao";
            String user = "root";
            String password = "ParolaMySQL16";
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}
