package org.example;

import java.sql.*;

public class Conncetion_Db implements DB {
    private static final String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static Connection conn;

    public Connection getCon() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("postgresql://localhost:5432/postgres", "postgres", "tryu1234");
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Driver not found", e);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}




