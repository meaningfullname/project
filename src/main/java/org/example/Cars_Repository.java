package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cars_Repository implements CarsRepotisory {
    private  String url;
    Cars car=null;
    private String user;

    private String password;


    public Cars_Repository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }


    @Override
    public void creation(Cars cars) {
        try{
            Class.forName("org.postgresql.Driver");

            Connection conn= DriverManager.getConnection("jdbc:postgresql:localhost:5432/Cars","postgres","tryu1234");
            String sql="SELECT * FROM carss";
            Statement st=conn.prepareStatement(sql);
            ((PreparedStatement) st).setString(1, cars.getBrand());
            ((PreparedStatement) st).setString(2,cars.getModel());
            ((PreparedStatement) st).setInt(3,cars.getPrice());
            ((PreparedStatement) st).setString(4, cars.getComplication());

            ((PreparedStatement) st).executeUpdate();
            st.close();
            conn.close();


        } catch(Exception e){
            System.out.println(e.getMessage());

        }


    }

    @Override
    public void getAllCars() {

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Cars", "postgres", "tryu1234");
            String sql = "SELECT * FROM carss";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Brand : "+rs.getInt("brand") + "  Model: "
                        + rs.getString("model") + "  Price :" + rs.getInt("price")+" Equipment: "+rs.getString("equipment"));


            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void chose(int row) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Cars", "postgres", "tryu1234");
            String sql = "SELECT brand,modele,price,equipment FROM cars";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.absolute(row)){
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("modele"));
                car.setPrice(rs.getInt("price"));
                car.setComplication(rs.getString("cars"));
            }




        }catch (Exception e) {
            System.out.println(e.getMessage());




        }

    }
    }
