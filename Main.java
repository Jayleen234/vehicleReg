//Vaheicle Reg by Jay

package com.cars;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collection;
// imprt necessary packages

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Collection<Car> cars = new ArrayList<>();
        // create objects and collections to use necessary packages

        // view menu options
        System.out.println(" Welcome");
        System.out.println("""
                 1. Capture vehicle details
                 2. View vehicle report
                 3. Update existing car color
                 4. Exit
                """);


        int menuOption = input.nextInt();

        while ((menuOption == 1) || (menuOption == 2) || (menuOption == 3)) {
            if (menuOption == 1) {
                Car carObj = new Car();
                int year;
                int millage;
                String make;
                String model;
                String plateNum = "";
                String vinNum;
                String color;

                System.out.println("Enter make");
                make = input.next();

                System.out.println("Enter model");
                model = input.next();

                System.out.println("Enter vin");
                vinNum = input.next();

                while (!(vinNum.length() == 17)) {
                    System.out.println("Vin number must be 17 characters. Please re-enter");
                    vinNum = input.next();
                }

                System.out.println("Enter 1 for old format license plate number and 2 for new format license plate numbers.");
                int plateChoice = input.nextInt();

                if (plateChoice == 1 || plateChoice == 2) {
                    System.out.println("Enter plate number");
                    plateNum = input.next();
                }

                System.out.println("Enter mileage");
                millage = input.nextInt();

                System.out.println("Enter year");
                year = input.nextInt();

                System.out.println("Enter vehicle color");
                color = input.next();

                carObj.setMake(make);
                carObj.setModel(model);
                carObj.setPlateNum(plateNum);
                carObj.setVin(vinNum);
                carObj.setYear(year);
                carObj.setMillage(millage);
                carObj.setColor(color);

                cars.add(carObj);

            } else if (menuOption == 2) {
                if (cars.isEmpty()) {
                    System.out.println(" No cars have been captured");
                } else {
                    System.out.println("VEHICLE REPORT");
                    for (Car carObject : cars) {
                        System.out.println("Make: " + carObject.getMake() +
                                " Model: " + carObject.getModel() +
                                " Plate Number: " + carObject.getPlateNum() +
                                " VIN: " + carObject.getVin() +
                                " Year: " + carObject.getYear() +
                                " Mileage: " + carObject.getMillage() +
                                " Color: " + carObject.getColor());
                    }
                }
            } else if (menuOption == 3) {
                if (cars.isEmpty()) {
                    System.out.println(" No cars have been captured" );
                } else {
                    System.out.println("Enter the VIN of the car you want to update the color for:");
                    String searchVin = input.next();

                    boolean found = false;
                    for (Car carObject : cars) {
                        if (carObject.getVin().equalsIgnoreCase(searchVin)) {
                            System.out.println("Current color: " + carObject.getColor());
                            System.out.println("Enter new color:");
                            String newColor = input.next();
                            carObject.setColor(newColor);
                            System.out.println("Color updated.");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println(" No car found with that VIN.");
                    }
                }
            }

            System.out.println("""
                    1. Capture vehicle details
                    2. View vehicle report
                    3. Update existing car color
                    4. Exit
                    """);
            menuOption = input.nextInt();
        }

        System.out.println("Thank You");
        input.close();
    }
}


