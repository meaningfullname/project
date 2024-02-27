package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cars_Repository implements CarsRepotisory,DB {
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
    public Connection getCon() {
        try{
            Class.forName("org.postgresql.Driver");

            Connection conn= DriverManager.getConnection(url,user,password);

            return conn;

        } catch(Exception e){
            return null;

        }
    }


    @Override
    public void creation(Cars cars) {
        try(Connection conn=getCon()){

            String sql="INSERT INTO cars (brand, model, price, equipment) VALUES (?, ?, ?, ?)";
            PreparedStatement st=conn.prepareStatement(sql);
            st.setString(1, cars.getBrand());
            st.setString(2, cars.getModel());
            st.setInt(3, cars.getPrice());
            st.setString(4, cars.getComplication());

            st.executeUpdate();
            st.close();
        } catch(Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void getAllCars() {

        try(Connection conn=getCon()) {

            String sql = "SELECT * FROM cars";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Brand : "+rs.getString("brand") + "  Model: "
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
        try(Connection conn=getCon()){



            String sql = "SELECT brand,modele,price,equipment FROM cars";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.absolute(row)){
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("modele"));
                car.setPrice(rs.getInt("price"));
                car.setEquipment(rs.getString("cars"));
            }




        }catch (Exception e) {
            System.out.println(e.getMessage());




        }

    }


}
