package org.example;

import java.util.List;

public class User {
    private static int lastId = 0;
    private int id;
    private String name;
    private String surname;
    private int wealth;
    private List<String> cars;
    public User(String name, String surname, int wealth){
        this.id = ++lastId;
        setName(name);
        setSurname(surname);

        setWealth(wealth);

    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for surname
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Getter for surname
    public String getSurname() {
        return surname;
    }

    // Setter for wealth
    public void setWealth(int wealth) {
        this.wealth = wealth;
    }

    // Getter for wealth
    public int getWealth() {
        return wealth;
    }

    // Setter for cars


    @Override
    public String toString() {
        return "User id"  +id+"User name :"+name+" surname "+ surname+" wealth"+wealth;
    }
}

