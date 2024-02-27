package org.example;

import org.example.*;

import java.util.List;
import java.util.Scanner;



public class Application {
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String password = "tryu1234";

    UserRepository userRep = new User_Repository(url,user,password);
    CarsRepotisory carsRep = new Cars_Repository(url, user, password);

    static Scanner scanner = new Scanner(System.in);

    public void start() {
        designOfApplication(20, 10);


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


                    User newUser = new User(name, surname, wealth);
                    userRep.creation(newUser);
                    break;
                case 2:
                    System.out.println("Enter car details:");
                    System.out.print("Name: ");
                    String carName = scanner.next();
                    System.out.print("Brand: ");
                    String brand = scanner.next();
                    System.out.print("Price: ");
                    int price = scanner.nextInt();
                    System.out.print("Equipment :");
                    String equipment = scanner.next();
                    System.out.print(" Cars count :");
                    int carscount = scanner.nextInt();

                    Cars newCar = new Cars(carName, brand, price, equipment,carscount);
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
                    System.out.println("Choose the user");
                    userRep.getAllUsers();
                    int optionforuser=scanner.nextInt();
                    userRep.choose(optionforuser);
                    System.out.println("Choose the car");
                    carsRep.getAllCars();
                    int optionforcars=scanner.nextInt();
                    carsRep.choosecars(optionforcars);
                    Cars car=null;
                    User user=null;
                    int newwealth;
                    if(car.getPrice()>user.getWealth()){
                        System.out.println("User doesn't have enough money");
                    }else{
                        newwealth=user.getWealth()-car.getPrice();

                        System.out.println("User buyed car");
                    }

                case 0:
                    System.out.println("Exiting program");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }


            System.out.print("Continue? (yes/no)");
            scanner.nextLine();
            String choice =scanner.nextLine().trim();
            choice.toLowerCase();
            if(!choice.equalsIgnoreCase("yes")){
                System.out.println("Exiting program");
                scanner.close();
                return;
            }



        }

    }


    public void designOfApplication(int width, int height) {

        printLine(width);


        for (int i = 0; i < height; i++) {
            if (i == height / 2) {
                printCenteredText("AUTOSALLON", width);
            } else {
                System.out.print("*");
                printSpaces(width - 2);
                System.out.println("*");
            }
        }


        printLine(width);
    }

    public static void printLine(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    public void printCenteredText(String text, int width) {
        int padding = (width - text.length()) / 2;
        printSpaces(padding);
        System.out.print(text);
        printSpaces(padding);
        if ((width - text.length()) % 2 != 0) {
            System.out.print(" ");
        }
        System.out.println();
    }
}