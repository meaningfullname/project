
package org.example;

public class Cars  {
    private String brand;
    private String model;
    private int price;
    private String complication;

    public Cars(String carName, String brand, double price) {

    }

    public Cars(String name, String model, int price,String complec) {
        setBrand(name);
        setModel(model);
        setComplication(complec);
        setPrice(price);
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


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















