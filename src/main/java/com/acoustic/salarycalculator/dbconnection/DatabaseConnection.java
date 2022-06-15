package com.acoustic.salarycalculator.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DatabaseConnection{

    private final Properties properties;
    private  Connection connection;

    public DatabaseConnection() {
        this.properties = new Properties();
    }

    public Connection getConnection() {

        try {
            properties.setProperty("user", DatabaseConfig.USER);
            properties.setProperty("password", DatabaseConfig.PASSWORD);

            connection = DriverManager.getConnection(DatabaseConfig.DATABASE_LOCAL_URL, properties);

        } catch (SQLException e) {
            System.out.println("Connection to the database failed, please check your setup");
        }
        return connection;
    }


}
