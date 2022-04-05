package com.springboot.workers.crudapi.util;

import java.sql.*;

public class DataBaseConnection {
	
    static final String url = "jdbc:mysql://localhost:3306/org";
    static final String username = "root";
    static final String password = "1234";
    private static Connection con = null;

    private DataBaseConnection() {
    }

    public static Connection getConnection() throws SQLException {
        if (con == null) {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully connected to database server "
                    + con.getMetaData().getDatabaseProductName()
                    + " version: "
                    + con.getMetaData().getDatabaseProductVersion());
        }
        return con;
    }

    public static void closeConnection() throws SQLException {
        con.close();
    }
}