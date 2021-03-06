package phuong.homework.controller;

import phuong.homework.service.VehicleServiceImpl;

import java.util.Scanner;

public class VehicleControl {
    public void displayManager() {
        Scanner sc = new Scanner(System.in);

        VehicleServiceImpl vehicleService = new VehicleServiceImpl();

        boolean flag = true;
        int choice;
        do {
            System.out.println("---------- VEHICLE MANAGER MENU ----------");
            System.out.println("1. Display vehicle" + "\n" +
                    "2. Add vehicle" + "\n" +
                    "3. Delete vehicle" + "\n" +
                    "4. Search vehicle by license plate" + "\n" +
                    "0. Exit");
            System.out.print("Your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    vehicleService.display();
                    break;
                case 2:
                    vehicleService.add();
                    break;
                case 3:
                    vehicleService.delete();
                    break;
                case 4:
                    vehicleService.search();
                    break;
                case 0:
                    System.out.println("---------- VEHICLE MANAGER IS CLOSE ----------");
                    flag = false;
                    break;
                default:
                    System.out.println("---------- CHOICE AGAIN! ----------");
                    break;
            }
        }while (flag);
    }
}
