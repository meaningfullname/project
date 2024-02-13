
package org.example;

import java.sql.*;

public class Cars  {
    private String brand;
    private String model;
    private int price;
    private String complication;

    public Cars() {

    }

    public Cars(String name, String model, int price,String complec) {
        setBrand(name);
        setModel(model);
        setComplication(complec);
        setPrice(price);
    }

    // Getter and Setter methods for Brand
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Getter and Setter methods for Model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Getter and Setter methods for Price
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Getter and Setter methods for Complication
    public String getComplication() {
        return complication;
    }

    public void setComplication(String complication) {
        this.complication = complication;
    }

    @Override
    public String toString() {
        return "Cars Brand "+ brand+" Model "+model+" Price "+price +" Equipment "+complication;
    }
}














}
