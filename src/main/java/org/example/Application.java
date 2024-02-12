package org.example;

import java.sql.*;
import java.util.Scanner;

public abstract class Application {

    private  Scanner scanner;

    public Application(){
        scanner = new Scanner(System.in);
    }






    public void Start() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (i == 0 || i == 19) {
                    System.out.print("*");

                } else if (j == 0 || j = 19) {
                    System.out.print("*");
                } else if (i == 10 && j == 10) {
                    System.out.print("AUTO SELLING");
                    j += 10;
                } else {
                    System.out.print(" ");
                }


            }
            System.out.println();
        }
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            printTableUser(user);
            System.out.println("This table of user ,choose one of them ");
            int option= scanner.nextInt();




        }


    }


    public Application(String url, String user, String password) {

    }
    public void printTableUser(String tablename){
        String sql = "SELECT * FROM " + tablename;

        try (Connection conn = DriverManager.getConnection("","","");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Print column names
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();

            // Print rows
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void printTable(String tableName) {
        // SQL query to retrieve data from the table
        String sql = "SELECT * FROM " + tableName;

        try (Connection conn = DriverManager.getConnection("","","");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Print column names
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();

            // Print rows
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public UserCon(int option){
        Statement stmt=null;
        User user=null;
        try(Connection conn=DriverManager.getConnection("","","")){
            String sql="SELECT * FROM your_table_name LIMIT ?, 1";
            try(PreparedStatement stmt=conn.prepareStatement(sql)){
                stmt.setInt(1, option - 1);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {

                        user = new User();


                        user.setName(rs.getString("name"));
                        user.setSurname(rs.getString("surname"));
                        user.setWealth(rs.getInt("wealth"));


                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }







}
