package phuong.case_study.furama_manager.controllers;

import phuong.case_study.furama_manager.sevice.BookingService;
import phuong.case_study.furama_manager.sevice.CustomerService;
import phuong.case_study.furama_manager.sevice.EmployeeService;
import phuong.case_study.furama_manager.sevice.FacilityService;
import phuong.case_study.furama_manager.sevice.impl.BookingServiceImpl;
import phuong.case_study.furama_manager.sevice.impl.CustomerServiceImpl;
import phuong.case_study.furama_manager.sevice.impl.EmployeeServiceImpl;
import phuong.case_study.furama_manager.sevice.impl.FacilityServiceImpl;

import java.util.Scanner;

public class FuramaController {
    private static Scanner sc = new Scanner(System.in);
    private static EmployeeService employeeService = new EmployeeServiceImpl();
    private static CustomerService customerService = new CustomerServiceImpl();
    private static FacilityService facilityService = new FacilityServiceImpl();
    private static BookingService bookingService = new BookingServiceImpl();
    public void displayMainMenu() {
        boolean flag = true;
        do {
            System.out.println("Main menu" + "\n" +
                    "1. Employee Management" + "\n" +
                    "2. Customer Management" + "\n" +
                    "3. Facility Management" + "\n" +
                    "4. Booking Management" + "\n" +
                    "5. Promotion Management" + "\n" +
                    "6. Exit");
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    choiceEmployee();
                    break;
                case 2:
                    choiceCustomer();
                break;
                case 3:
                    choiceFacility();
                    break;
                case 4:
                    choiceBooking();
                    break;
                case 5:
                    choicePromotion();
                    break;
                case 6:
                    flag = false;
                    break;
            }

        } while (flag);
    }

    private void choicePromotion() {
        boolean flag = true;
        do {
            System.out.println("Promotion menu" + "\n" +
                    "1. Display list customers use service" + "\n" +
                    "2. Display list customers get voucher" + "\n" +
                    "3. Return main menu");
            System.out.print("Your choice: ");
            int choicePromotion = Integer.parseInt(sc.nextLine());
            switch (choicePromotion) {
                case 1:
                case 2:
                case 3:
                    flag = false;
                    break;
            }

        } while (flag);
    }

    private void choiceBooking() {
        boolean flag = true;
        do {
            System.out.println("Booking menu" + "\n" +
                    "1. Add new booking" + "\n" +
                    "2. Display list booking" + "\n" +
                    "3. Create new contracts" + "\n" +
                    "4. Display list contracts" + "\n" +
                    "5. Edit contracts" + "\n" +
                    "6. Return main menu");
            System.out.print("Your choice: ");
            int choiceBooking = Integer.parseInt(sc.nextLine());
            switch (choiceBooking) {
                case 1:
                    bookingService.addNewBooking();
                    break;
                case 2:
                    bookingService.displayListBooking();
                    break;
                case 3:

                case 4:
                case 5:
                case 6:
                    flag = false;
                    break;
            }

        } while (flag);
    }

    private void choiceFacility() {
        boolean flag = true;
        do {
            System.out.println("Facility menu" + "\n" +
                    "1. Display list facility" + "\n" +
                    "2. Add new facility" + "\n" +
                    "3. Display list facility maintenance" + "\n" +
                    "4. Return main menu");
            System.out.print("Your choice: ");
            int choiceFacility = Integer.parseInt(sc.nextLine());
            switch (choiceFacility) {
                case 1:
                    facilityService.displayListFacility();
                    break;
                case 2:
                    choiceFacilityService();
                    break;
                case 3:
                    facilityService.displayMaintenance();
                    break;
                case 4:
                    flag = false;
                    break;
            }

        } while (flag);
    }

    private void choiceFacilityService() {
        boolean flag = true;
        do {
            System.out.println("Facility service menu" + "\n" +
                    "1. Add new House" + "\n" +
                    "2. Add new Room" + "\n" +
                    "3. Add new Villa" + "\n" +
                    "4. Return main menu");
            System.out.print("Your choice: ");
            int choiceFacilityService = Integer.parseInt(sc.nextLine());
            switch (choiceFacilityService) {
                case 1:
                    facilityService.addNewHouseService();
                    break;
                case 2:
                    facilityService.addNewRoomService();
                    break;
                case 3:
                    facilityService.addNewVillaService();
                    break;
                case 4:
                    flag = false;
                    break;
            }

        } while (flag);
    }

    private void choiceCustomer() {
        boolean flag = true;
        do {
            System.out.println("Customer menu" + "\n" +
                    "1. Display list customers" + "\n" +
                    "2. Add new customer" + "\n" +
                    "3. Edit customer" + "\n" +
                    "4. Return main menu");
            System.out.print("Your choice: ");
            int choiceCustomer = Integer.parseInt(sc.nextLine());
            switch (choiceCustomer) {
                case 1:
                    customerService.display();
                    break;
                case 2:
                    customerService.add();
                    break;
                case 3:
                    customerService.edit();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Choice again!");
                    break;
            }
        } while (flag);
    }

    private void choiceEmployee() {
        boolean flag = true;
        do {
            System.out.println("Employee menu" + "\n" +
                    "1. Display list employees" + "\n" +
                    "2. Add new employee" + "\n" +
                    "3. Edit employee" + "\n" +
                    "4. Return main menu");
            System.out.print("Your choice: ");
            int choiceEmployee = Integer.parseInt(sc.nextLine());
            switch (choiceEmployee) {
                case 1:
                    employeeService.display();
                    break;
                case 2:
                    employeeService.add();
                    break;
                case 3:
                    employeeService.edit();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Choice again!");
                    break;
            }
        } while (flag);
    }
}
