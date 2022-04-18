package phuong.case_study.furama_manager.controllers;

import java.util.Scanner;

public class FuramaController {
    public void displayMainMenu() {
        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        int choice;
        do {
            System.out.println("Main menu" + "\n" +
                    "1.Employee Management" + "\n" +
                    "2. Customer Management" + "\n" +
                    "3. Facility Management" + "\n" +
                    "4. Booking Management" + "\n" +
                    "5. Promotion Management" + "\n" +
                    "6. Exit");
            System.out.print("Your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    do {
                        System.out.println("Main menu" + "\n" +
                                "1. Display list employees" + "\n" +
                                "2. Add new employee" + "\n" +
                                "3. Edit employee" + "\n" +
                                "4. Return main menu");
                        System.out.print("Your choice: ");
                        choice = Integer.parseInt(sc.nextLine());
                        switch (choice) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                flag = false;
                                break;
                        }

                    } while (flag);
                    flag = true;
                    break;
                case 2:
                    do {
                        System.out.println("Main menu" + "\n" +
                                "1. Display list customers" + "\n" +
                                "2. Add new customer" + "\n" +
                                "3. Edit customer" + "\n" +
                                "4. Return main menu");
                        System.out.print("Your choice: ");
                        choice = Integer.parseInt(sc.nextLine());
                        switch (choice) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                flag = false;
                                break;
                        }

                    } while (flag);
                    flag = true;
                    break;
                case 3:
                    do {
                        System.out.println("Main menu" + "\n" +
                                "1. Display list facility" + "\n" +
                                "2. Add new facility" + "\n" +
                                "3. Display list facility maintenance" + "\n" +
                                "4. Return main menu");
                        System.out.print("Your choice: ");
                        choice = Integer.parseInt(sc.nextLine());
                        switch (choice) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                flag = false;
                                break;
                        }

                    } while (flag);
                    flag = true;
                    break;
                case 4:
                    do {
                        System.out.println("Main menu" + "\n" +
                                "1. Add new booking" + "\n" +
                                "2. Display list booking" + "\n" +
                                "3. Create new constracts" + "\n" +
                                "4. Display list contracts" + "\n" +
                                "5. Edit contracts" + "\n" +
                                "6. Return main menu");
                        System.out.print("Your choice: ");
                        choice = Integer.parseInt(sc.nextLine());
                        switch (choice) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                flag = false;
                                break;
                        }

                    } while (flag);
                    flag = true;
                    break;
                case 5:
                    do {
                        System.out.println("Main menu" + "\n" +
                                "1. Display list customers use service" + "\n" +
                                "2. Display list customers get voucher" + "\n" +
                                "3. Return main menu");
                        System.out.print("Your choice: ");
                        choice = Integer.parseInt(sc.nextLine());
                        switch (choice) {
                            case 1:
                            case 2:
                            case 3:
                                flag = false;
                                break;
                        }

                    } while (flag);
                    flag = true;
                    break;
                case 6:
                    flag = false;
                    break;
            }

        } while (flag);
    }
}
