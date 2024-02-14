package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Application {
    String url = "jdbc:postgresql://localhost:5432/your_database_name";
    String user = "postgres";
    String password = "123456";

    UserRoptisory userrep = new User_Repository(url, user, password);
    CarsRepotisory carsrep = new Cars_Repository(url, user, password);

    static Scanner scanner = new Scanner(System.in);
    public void Start() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (i == 0 || i == 19) {
                    System.out.print("*");

                } else if (j == 0 || j = 19) {
                    System.out.print("*");
                } else if (i == 10 && j == 10) {
                    System.out.print("AUTO SELLING");
                    j += 10;
                } else {
                    System.out.print(" ");
                }


            }
            System.out.println();
        }
        while (true) {
            System.out.println();
            System.out.println("Welcome to our Application");

            System.out.println("This table of user ,choose one of them ");
            System.out.println("1. Add user");
            System.out.println("2. Add car");
            System.out.println("3. Print table of users");
            System.out.println("4. Print table of cars");
            System.out.println("5. Get cars for a user");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");




            int option= scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter user details:");
                    System.out.print("Name: ");
                    String name = scanner.next();
                    System.out.print("Surname: ");
                    String surname = scanner.next();
                    System.out.print("Wealth: ");
                    int wealth = scanner.nextInt();

                    User newUser = new User(name, surname, wealth);
                    UserRoptisory.Creation(newUser);
                    break;
                case 2:
                    System.out.println("Enter car details:");
                    System.out.print("Name: ");
                    String carName = scanner.next();
                    System.out.print("Brand: ");
                    String brand = scanner.next();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    Cars newCar = new Cars(carName, brand, price);
                    CarsRepotisory.Creation(newCar);
                    break;
                case 3:
                    List<User> users = User_Repository.getAllUsers();
                    System.out.println("Table of Users:");
                    for (User u : users) {
                        System.out.println(u.getName() + "\t" + u.getSurname() + "\t" + u.getWealth());
                    }
                    break;
                case 4:
                    List<Cars> car = Cars_Repository.getAllCars();
                    System.out.println("Table of Cars:");
                    for (Cars c : car) {
                        System.out.println(c.getBrand() + "\t" + c.getModel() + "\t" + c.getPrice());
                    }
                    break;
                case 5:
                    // Implement logic to get cars for a user
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }








        }


    }




}



