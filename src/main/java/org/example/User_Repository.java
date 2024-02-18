package org.example;

import java.sql.*;
import java.util.List;

public class User_Repository implements UserRoptisory{

    User user1=null;

    private  String url;
    private String user;
    private String password;


    public User_Repository() {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void creation(User user) {
        try{
            Class.forName("org.postgresql.Driver");

            Connection conn= DriverManager.getConnection("jdbc:postgresql:localhost:5432/Cars","postgres","tryu1234");
            String sql="INSERT INTO users (name, surname, wealth, cars) VALUES (?, ?, ?, ?)";
            Statement st=conn.prepareStatement(sql);
            ((PreparedStatement) st).setString(1, user.getName());
            ((PreparedStatement) st).setString(2,user.getSurname());
            ((PreparedStatement) st).setInt(3,user.getWealth());
            ((PreparedStatement) st).setArray(4, (Array) user.getCars());


            ((PreparedStatement) st).executeUpdate();
            st.close();
            conn.close();


        } catch(Exception e){
            System.out.println(e.getMessage());


        }

    }
    public User getAllUsers() {

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Cars", "postgres", "tryu1234");
            String sql = "SELECT *FROM users";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("wealth") + "  "
                        + rs.getString("surname") + "  " + rs.getString("name")+rs.getArray("cars"));

            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void choose(int row) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Cars", "postgres", "tryu1234");
            String sql = "SELECT *  FROM cars";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.absolute(row)){
                user1.setName(rs.getString("name"));
                user1.setSurname(rs.getString("surname"));
                user1.setWealth(rs.getInt("wealth"));
                user1.setCars((List<String>) rs.getArray("cars"));
            }



        }catch (Exception e) {
            System.out.println(e.getMessage());




        }

    }
}