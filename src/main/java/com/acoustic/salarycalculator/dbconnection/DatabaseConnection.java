package com.acoustic.salarycalculator.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DatabaseConnection {

    private final Properties properties;

    public DatabaseConnection() {
        this.properties = new Properties();
    }

    public Connection getConnection() {
        try {
            properties.setProperty("user", DatabaseConfig.USER);
            properties.setProperty("password", DatabaseConfig.PASSWORD);

            return DriverManager.getConnection(DatabaseConfig.DATABASE_LOCAL_URL, properties);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
