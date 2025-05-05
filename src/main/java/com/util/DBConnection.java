package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL      = System.getenv("ZUMBA_DB_URL");
    private static final String USER     = System.getenv("ZUMBA_DB_USER");
    private static final String PASSWORD = System.getenv("ZUMBA_DB_PASSWORD");

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection failed!");
        }
        return connection;
    }
}
