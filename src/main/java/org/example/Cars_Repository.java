package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cars_Repository implements CarsRepotisory {
    private  String url;
    private String user;

    private String password;


    public Cars_Repository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void Creation(Cars cars) {
        try{
            Class.forName("org.postgresql.Driver");

            Connection conn= DriverManager.getConnection("jdbc:postgresql:localhost:5432/Cars","postgres","123456");
            String sql="SELECT brand,modele,price,equipment FROM Cars";
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
    public static List<Cars> getAllCars() {
        List<Cars> carsList = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Cars", "postgres", "123456");
            String sql = "SELECT brand, modele, price, equipment FROM Cars";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String brand = rs.getString("brand");
                String modele = rs.getString("modele");
                int price = rs.getInt("price");
                String equipment = rs.getString("equipment");
                Cars car = new Cars(brand, modele, price, equipment);
                carsList.add(car);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return carsList;
    }
}