package org.example;

import org.example.*;

import java.util.List;
import java.util.Scanner;



public class Application {
    String url = "jdbc:postgresql://localhost:5432/Cars";
    String user = "postgres";
    String password = "13579";

    UserRoptisory userRep = new User_Repository();
    CarsRepotisory carsRep = new Cars_Repository(url, user, password);

    static Scanner scanner = new Scanner(System.in);

    public void start() {
        toString();

        while (true) {
            System.out.println();
            System.out.println("Welcome to our Application");
            System.out.println("This table of user, choose one of them ");
            System.out.println("1. Add user");
            System.out.println("2. Add car");
            System.out.println("3. Print table of users");
            System.out.println("4. Print table of cars");
            System.out.println("5. Get cars for a user");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter user details:");
                    System.out.print("Name: ");
                    String name = scanner.next();
                    System.out.print("Surname: ");
                    String surname = scanner.next();
                    System.out.print("Wealth: ");
                    int wealth = scanner.nextInt();

                    List<String> cars = null;
                    User newUser = new User(name, surname, wealth, cars);
                    userRep.creation(newUser);
                    break;
                case 2:
                    System.out.println("Enter car details:");
                    System.out.print("Name: ");
                    String carName = scanner.next();
                    System.out.print("Brand: ");
                    String brand = scanner.next();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Equipment :");
                    String equipment = scanner.next();

                    Cars newCar = new Cars(carName, brand, price, equipment);
                    carsRep.creation(newCar);
                    break;
                case 3:
                    System.out.println("Table of Users");
                    userRep.getAllUsers();
                    break;
                case 4:
                    System.out.println("Table of Cars:");
                    carsRep.getAllCars();
                    break;
                case 5:
                    System.out.println("Choose the user: ");
                    userRep.getAllUsers();
                    int userId = scanner.nextInt();
                    userRep.choose(userId);
                    User selectedUser = userRep.getAllUsers();
                    if (selectedUser != null) {
                        System.out.println("Cars owned by " + selectedUser.getName() + " " + selectedUser.getSurname() + ":");
                        cars = List.of(selectedUser.getCars().toString());
                        if (cars.isEmpty()) {
                            System.out.println("No cars found for this user.");
                        } else {
                            for (String car : cars) {
                                System.out.println(car);
                            }
                        }
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting program");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            System.out.print("Continue? (yes/no)");
        }
    }
}