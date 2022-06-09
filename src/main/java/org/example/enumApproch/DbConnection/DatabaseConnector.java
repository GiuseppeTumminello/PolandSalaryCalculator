package org.example.enumApproch.DbConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DatabaseConnector {
    private final Properties properties;
    public static final String DATABASE_LOCAL_URL = "jdbc:postgresql://"+DatabaseConfig.HOST+ ":" + DatabaseConfig.PORT + "/";

    public DatabaseConnector() {
        this.properties = new Properties();
    }

    public Connection getConnection() {
        try {
            String url = DATABASE_LOCAL_URL + DatabaseConfig.DATABASE_NAME;
            properties.setProperty("user", DatabaseConfig.USER);
            properties.setProperty("password", DatabaseConfig.PASSWORD);

            return DriverManager.getConnection(url, properties);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
