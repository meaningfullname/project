package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User_Repository implements UserRoptisory{

    private  String url;
    private String user;

    private String password;

    public User_Repository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void Creation(User user) {
        try{
            Class.forName("org.postgresql.Driver");

            Connection conn= DriverManager.getConnection("jdbc:postgresql:localhost:5432/User","postgres","123456");
            String sql="SELECT name,surname,wealth,cars FROM User";
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

    @Override
    public static List<User> getAllUsers() {
        List<User> carsList = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/User", "postgres", "123456");
            String sql = "SELECT name, surname, wealth, cars FROM User";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int wealth = rs.getInt("wealth");
                ArrayList cars= (ArrayList) rs.getArray("cars");
                User user = new User(name, surname, wealth);
                getAllUsers().add(user);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return getAllUsers();
    }
    }

