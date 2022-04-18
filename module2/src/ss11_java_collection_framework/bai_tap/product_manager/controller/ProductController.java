package ss11_java_collection_framework.bai_tap.product_manager.controller;

import ss11_java_collection_framework.bai_tap.product_manager.service.ICarService;
import ss11_java_collection_framework.bai_tap.product_manager.service.ITruckService;
import ss11_java_collection_framework.bai_tap.product_manager.service.impl.CarService;
import ss11_java_collection_framework.bai_tap.product_manager.service.impl.TruckService;

import java.util.Scanner;

public class ProductController {
    private static Scanner sc = new Scanner(System.in);
    private static ICarService carService = new CarService();
    private static ITruckService truckService = new TruckService();

    public void display() {
        boolean flag = true;
        while (flag) {
            System.out.println("Main menu" + "\n" +
                    "1. Add new product" + "\n" +
                    "2. Display product" + "\n" +
                    "3. Delete product" + "\n" +
                    "4. Search product" + "\n" +
                    "5. Update product" + "\n" +
                    "0. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    choiceProductForAdd();
                    break;
                case 2:
                    choiceProductForDisplay();
                    break;
                case 3:
                    choiceProductForDelete();
                    break;
                case 4:
                    choiceProductForSearch();
                    break;
                case 5:
                    choiceProductForUpdate();
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Choice again!");
            }
        }
    }

    private void choiceProductForUpdate() {
        boolean flag = true;
        while (flag) {
            System.out.println("Main menu" + "\n" +
                    "1. Update vehicle" + "\n" +
                    "2. Update house" + "\n" +
                    "0. Exit");
            System.out.print("Enter your choice 1: ");
            int choiceProduct = Integer.parseInt(sc.nextLine());

            switch (choiceProduct) {
                case 1:
                    choiceVehicleForUpdate();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Choice again!");
            }
        }
    }

    private void choiceVehicleForUpdate() {
        boolean flag = true;
        while (flag) {
            System.out.println("Main menu" + "\n" +
                    "1. Update car" + "\n" +
                    "2. Update truck" + "\n" +
                    "0. Exit");
            System.out.print("Enter your choice: ");
            int choiceVehicle = Integer.parseInt(sc.nextLine());

            switch (choiceVehicle) {
                case 1:
                    carService.updateById();
                    break;
                case 2:
                    truckService.updateById();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Choice again!");
            }
        }
    }

    private void choiceProductForSearch() {
        boolean flag = true;
        while (flag) {
            System.out.println("Main menu" + "\n" +
                    "1. Search vehicle" + "\n" +
                    "2. Search house" + "\n" +
                    "0. Exit");
            System.out.print("Enter your choice: ");
            int choiceProduct = Integer.parseInt(sc.nextLine());

            switch (choiceProduct) {
                case 1:
                    choiceVehicleForSearch();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Choice again!");
            }
        }
    }

    private void choiceVehicleForSearch() {
        boolean flag = true;
        while (flag) {
            System.out.println("Main menu" + "\n" +
                    "1. Search car" + "\n" +
                    "2. Search truck" + "\n" +
                    "0. Exit");
            System.out.print("Enter your choice: ");
            int choiceVehicle = Integer.parseInt(sc.nextLine());

            switch (choiceVehicle) {
                case 1:
                    carService.searchByName();
                    break;
                case 2:
                    truckService.searchByName();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Choice again!");
            }
        }
    }

    private void choiceProductForDelete() {
        boolean flag = true;
        while (flag) {
            System.out.println("Main menu" + "\n" +
                    "1. Delete vehicle" + "\n" +
                    "2. Delete house" + "\n" +
                    "0. Exit");
            System.out.print("Enter your choice: ");
            int choiceProduct = Integer.parseInt(sc.nextLine());

            switch (choiceProduct) {
                case 1:
                    choiceVehicleForDelete();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Choice again!");
            }
        }
    }

    private void choiceVehicleForDelete() {
        boolean flag = true;
        while (flag) {
            System.out.println("Main menu" + "\n" +
                    "1. Delete car" + "\n" +
                    "2. Delete truck" + "\n" +
                    "0. Exit");
            System.out.print("Enter your choice: ");
            int choiceVehicle = Integer.parseInt(sc.nextLine());

            switch (choiceVehicle) {
                case 1:
                    carService.deleteById();
                    break;
                case 2:
                    truckService.deleteById();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Choice again!");
            }
        }
    }

    private void choiceProductForDisplay() {
        boolean flag = true;
        while (flag) {
            System.out.println("Main menu" + "\n" +
                    "1. Display vehicle" + "\n" +
                    "2. Display house" + "\n" +
                    "0. Exit");
            System.out.print("Enter your choice: ");
            int choiceProduct = Integer.parseInt(sc.nextLine());

            switch (choiceProduct) {
                case 1:
                    choiceVehicleForDisplay();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Choice again!");
            }
        }
    }

    private void choiceVehicleForDisplay() {
        boolean flag = true;
        while (flag) {
            System.out.println("Main menu" + "\n" +
                    "1. Display car" + "\n" +
                    "2. Display truck" + "\n" +
                    "0. Exit");
            System.out.print("Enter your choice: ");
            int choiceVehicle = Integer.parseInt(sc.nextLine());

            switch (choiceVehicle) {
                case 1:
                    carService.displayProduct();
                    break;
                case 2:
                    truckService.displayProduct();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Choice again!");
            }
        }
    }

    private void choiceProductForAdd() {
        boolean flag = true;
        while (flag) {
            System.out.println("Main menu" + "\n" +
                    "1. Add new vehicle" + "\n" +
                    "2. Add new house" + "\n" +
                    "0. Exit");
            System.out.print("Enter your choice: ");
            int choiceProduct = Integer.parseInt(sc.nextLine());
            switch (choiceProduct) {
                case 1:
                    choiceVehicleForAdd();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Choice again!");
            }
        }
    }

    private void choiceVehicleForAdd() {
        boolean flag = true;
        while (flag) {
            System.out.println("Main menu" + "\n" +
                    "1. Add new car" + "\n" +
                    "2. Add new truck" + "\n" +
                    "0. Exit");
            System.out.print("Enter your choice: ");
            int choiceVehicle = Integer.parseInt(sc.nextLine());
            switch (choiceVehicle) {
                case 1:
                    carService.addNewProduct();
                    break;
                case 2:
                    truckService.addNewProduct();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Choice again!");
            }
        }
    }
}
