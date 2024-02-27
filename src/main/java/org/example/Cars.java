
package org.example;

public class Cars  {
    private String brand;
    private String model;
    private int price;
    private String equipment;



    public Cars(String name, String model, int price,String equipment) {
        setBrand(name);
        setModel(model);
        setEquipment(equipment);
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
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Cars Brand "+ brand+" Model "+model+" Price "+price +" Equipment "+equipment;
    }
}















