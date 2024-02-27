package org.example;

import java.sql.*;
import java.util.List;

public class User_Repository implements UserRoptisory,DB{

    User user12=null;

    private  String url;
    private String user;
    private String password;



    public User_Repository(String url, String user, String password) {
        this.url = this.url;
        this.user = this.user;
        this.password = this.password;
    }

    @Override
    public Connection getCon() {
        try{
            Class.forName("org.postgresql.Driver");

            Connection conn= DriverManager.getConnection(url,user,password);

            return conn;

        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;

        }
    }

    @Override
    public void creation(User user) {
        try(Connection conn=getCon()){

            String sql="SELECT name,surname,wealth,cars FROM users";
            Statement st=conn.prepareStatement(sql);
            ((PreparedStatement) st).setString(1, user.getName());
            ((PreparedStatement) st).setString(2,user.getSurname());
            ((PreparedStatement) st).setInt(3,user.getWealth());



            ((PreparedStatement) st).executeUpdate();
            st.close();
            conn.close();


        } catch(Exception e){
            System.out.println(e.getMessage());


        }

    }
    public User getAllUsers() {
        Statement st=null;
        ResultSet rs=null;


        try(Connection conn=getCon()) {

            String sql = "SELECT * FROM users";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("name") + "  "
                        + rs.getString("surname") + "  " + rs.getInt("wealth"));


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
        try(Connection conn=getCon()) {

            String sql = "SELECT brand, modele,price,equipment  FROM cars";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.absolute(row)){
                user12.setName(rs.getString("name"));
                user12.setSurname(rs.getString("surname"));
                user12.setWealth(rs.getInt("wealth"));
                user12.setCars((List<String>) rs.getArray("cars"));
            }



            }catch (Exception e) {
            System.out.println(e.getMessage());




        }

    }
}

