package phuong.case_study.furama_manager.sevice.impl;

import phuong.case_study.furama_manager.model.booking.Booking;
import phuong.case_study.furama_manager.model.furuma.Facility;
import phuong.case_study.furama_manager.model.person.Customer;
import phuong.case_study.furama_manager.sevice.BookingService;
import phuong.case_study.furama_manager.sevice.FacilityService;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BookingServiceImpl implements BookingService {
    private static Scanner sc = new Scanner(System.in);
    private static Set<Booking> bookingService = new TreeSet<>();
    private static FacilityService facilityService = new FacilityServiceImpl();
    private final static String PATTERN = "dd-MM-yyyy";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);

    static {
        Date dateStart1 = null;
        Date dateEnd1 = null;
        Date dateStart2 = null;
        Date dateEnd2 = null;
        Date dateStart3 = null;
        Date dateEnd3 = null;
        try {
            dateStart1 = dateFormat.parse("15-03-2022");
            dateEnd1 = dateFormat.parse("21-03-2022");
            dateStart2 = dateFormat.parse("16-03-2022");
            dateEnd2 = dateFormat.parse("22-03-2022");
            dateStart3 = dateFormat.parse("17-03-2022");
            dateEnd3 = dateFormat.parse("23-03-2022");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Booking booking1 = new Booking("5", dateStart1, dateEnd1, "1", "Villa", "1");
        Booking booking2 = new Booking("5", dateStart2, dateEnd2, "1", "Villa", "1");
        Booking booking3 = new Booking("5", dateStart3, dateEnd3, "1", "Villa", "1");
        bookingService.add(booking1);
        bookingService.add(booking2);
        bookingService.add(booking3);

    }

    public static Set<Booking> getBookingService() {
        return bookingService;
    }

    @Override
    public void addNewBooking() {
        System.out.print("Enter booking id: ");
        String id = sc.nextLine();
        System.out.print("Enter date start (dd-MM-yyyy): ");
        Date dateStart = null;
        try {
            dateStart = dateFormat.parse(sc.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.print("Enter date end (dd-MM-yyyy): ");
        Date dateEnd = null;
        try {
            dateEnd = dateFormat.parse(sc.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Choice customer id");
        String customerId = choiceListCustomer().getId();

        System.out.println("Choice service");
        String serviceName = choiceService().getServiceName();

        System.out.print("Enter service id: ");
        String serviceId = sc.nextLine();

        Booking booking = new Booking(id, dateStart, dateEnd, customerId, serviceName, serviceId);
        bookingService.add(booking);

    }

    @Override
    public void displayListBooking() {
        for (Booking booking: bookingService) {
            System.out.println(booking);
        }
    }

    public Facility choiceService() {
        List<Facility> facilities = FacilityServiceImpl.getFacilities();

        do {
            System.out.println("Facility list");
            for (int i = 0; i < facilities.size(); i++) {
                System.out.println((i + 1) + ". " + "Service name: " + facilities.get(i).getServiceName());
            }
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice > 0 && choice <= facilities.size()) {
                facilityService.add(facilities.get(choice - 1));
                return facilities.get(choice - 1);
            } else {
                System.out.println("Choice again!");
            }
        } while (true);
    }

    public Customer choiceListCustomer() {
        List<Customer> customers = CustomerServiceImpl.getCustomers();

        do {
            System.out.println("Customer list");
            for (int i = 0; i < customers.size(); i++) {
                System.out.println((i + 1) + ". " + "ID: " + customers.get(i).getId() + " - " + "Name: " + customers.get(i).getName());
            }
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice > 0 && choice <= customers.size()) {
                System.out.println(customers.size());
                return customers.get(choice - 1);
            } else {
                System.out.println("Choice again!");
            }
        } while (true);
    }

    public static void main(String[] args) {
        BookingService bookingService = new BookingServiceImpl();
        bookingService.addNewBooking();

        Set<Booking> bookingServices = BookingServiceImpl.getBookingService();

        for (Booking booking : bookingServices) {
            System.out.println(booking);
        }

        facilityService.displayNumberUsedOfService();
    }
}
