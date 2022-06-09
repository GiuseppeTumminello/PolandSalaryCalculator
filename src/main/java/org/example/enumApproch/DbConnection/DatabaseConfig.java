package org.example.enumApproch.DbConnection;

public class DatabaseConfig {
    protected static final String HOST = "localhost";
    protected static final String PASSWORD ="password";
    protected static final String PORT = "5432";
    protected static final String USER = "postgres";
    protected static final String DATABASE_NAME = "postgres";

    protected static final String DATABASE_LOCAL_URL = "jdbc:postgresql://"+DatabaseConfig.HOST+ ":" + DatabaseConfig.PORT + "/";


}
