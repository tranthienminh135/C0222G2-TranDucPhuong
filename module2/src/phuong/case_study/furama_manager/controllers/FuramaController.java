package phuong.case_study.furama_manager.controllers;

import phuong.case_study.furama_manager.common.CheckEx;
import phuong.case_study.furama_manager.sevice.*;
import phuong.case_study.furama_manager.sevice.impl.*;

import java.util.Scanner;

public class FuramaController {
    private static Scanner sc = new Scanner(System.in);
    private static EmployeeService employeeService = new EmployeeServiceImpl();
    private static CustomerService customerService = new CustomerServiceImpl();
    private static FacilityService facilityService = new FacilityServiceImpl();
    private static BookingService bookingService = new BookingServiceImpl();
    private static ContactService contactService = new ContactServiceImpl();
    private static PromotionService promotionService = new PromotionServiceImpl();
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
            int choice = 0;
            choice = CheckEx.checkExForChoice(choice);
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
                default:
                    System.err.println("Choice again!");
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
            int choicePromotion = 0;
            choicePromotion = CheckEx.checkExForChoice(choicePromotion);
            switch (choicePromotion) {
                case 1:
                    promotionService.displayListCustomersUseService();
                    break;
                case 2:
                    promotionService.voucher();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.err.println("Choice again!");
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
            int choiceBooking = 0;
            choiceBooking = CheckEx.checkExForChoice(choiceBooking);
            switch (choiceBooking) {
                case 1:
                    bookingService.addNewBooking();
                    break;
                case 2:
                    bookingService.displayListBooking();
                    break;
                case 3:
                    contactService.createNewContract();
                    break;
                case 4:
                    contactService.displayListContract();
                    break;
                case 5:
                    contactService.editContract();
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.err.println("Choice again!");
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
            int choiceFacility = 0;
            choiceFacility = CheckEx.checkExForChoice(choiceFacility);
            switch (choiceFacility) {
                case 1:
                    facilityService.displayNumberUsedOfService();
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
                default:
                    System.err.println("Choice again!");
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
            int choiceFacilityService = 0;
            choiceFacilityService = CheckEx.checkExForChoice(choiceFacilityService);
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
                default:
                    System.err.println("Choice again!");
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
            int choiceCustomer = 0;
            choiceCustomer = CheckEx.checkExForChoice(choiceCustomer);
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
            int choiceEmployee = 0;
            choiceEmployee = CheckEx.checkExForChoice(choiceEmployee);
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
