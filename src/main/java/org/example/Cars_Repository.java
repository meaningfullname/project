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

            String sql="INSERT INTO cars (brand, model, price, equipment,carscount) VALUES (?, ?, ?, ?)";
            PreparedStatement st=conn.prepareStatement(sql);
            st.setString(1, cars.getBrand());
            st.setString(2, cars.getModel());
            st.setInt(3, cars.getPrice());
            st.setString(4, cars.getComplication());
            st.setInt(5,cars.getCarscount());

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
                        + rs.getString("model") + "  Price :" + rs.getInt("price")+
                        " Equipment: "+rs.getString("equipment")+" Cars count : "+ rs.getInt("countofcars"));


            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void choosecars(int row) {
        try(Connection conn=getCon()){



            String sql = "SELECT *FROM cars";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.absolute(row)){
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("modele"));
                car.setPrice(rs.getInt("price"));
                car.setEquipment(rs.getString("cars"));
                car.setCarscount(rs.getInt("countofcars"));
            }




        }catch (Exception e) {
            System.out.println(e.getMessage());




        }

    }

    @Override
    public void update(Cars cars) {
        try (Connection conn = getCon()) {
            String sql = "UPDATE cars SET carscount = newcarscount WHERE id = row";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, cars.getCarscount());
                stmt.setInt(2, cars.getId());

                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exceptions appropriately
        }

    }


}
