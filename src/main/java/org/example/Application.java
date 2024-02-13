package org.example;

import java.sql.*;
import java.util.Scanner;

class Application {

    private  Scanner scanner;
    Printtable table=new Printtable();

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
            System.out.println("Welcome to our Application");

            System.out.println("This table of user ,choose one of them ");
            table.Print("Users");

            int option= scanner.nextInt();
            UserCon(option);
            System.out.println("Chose car that you want to buy");

            table.Print("Cars");






        }


    }




    public void UserCon(int option){
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


}



