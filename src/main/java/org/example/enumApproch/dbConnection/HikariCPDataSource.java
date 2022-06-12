package org.example.enumApproch.dbConnection;


import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class HikariCPDataSource {

    private final HikariDataSource dataSource;

    public HikariCPDataSource() {
        HikariConfig configuration = new HikariConfig();
        configuration.setJdbcUrl(DatabaseConfig.DATABASE_LOCAL_URL);
        configuration.setUsername(DatabaseConfig.USER);
        configuration.setPassword(DatabaseConfig.PASSWORD);
        configuration.addDataSourceProperty("cachePrepStmts", "true");
        configuration.addDataSourceProperty("prepStmtCacheSize", "250");
        configuration.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        dataSource = new HikariDataSource(configuration);
    }


    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
