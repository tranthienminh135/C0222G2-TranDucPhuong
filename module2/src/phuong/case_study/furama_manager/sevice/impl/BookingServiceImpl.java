package phuong.case_study.furama_manager.sevice.impl;

import phuong.case_study.furama_manager.common.CheckException;
import phuong.case_study.furama_manager.common.FileService;
import phuong.case_study.furama_manager.model.booking.Booking;
import phuong.case_study.furama_manager.model.facility.Facility;
import phuong.case_study.furama_manager.model.person.Customer;
import phuong.case_study.furama_manager.sevice.BookingService;
import phuong.case_study.furama_manager.sevice.FacilityService;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BookingServiceImpl implements BookingService {
    private final static String FILE_NAME_BOOKING = "src/phuong/case_study/furama_manager/common/data/booking.csv";
    private final static String FILE_NAME_CUSTOMER = "src/phuong/case_study/furama_manager/common/data/customer.csv";
    private static Scanner sc = new Scanner(System.in);
    private static Set<Booking> bookings = new TreeSet<>();
    private static FacilityService facilityService = new FacilityServiceImpl();
    private final static String PATTERN = "dd-MM-yyyy";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
    private static List<Facility> facilities = FacilityServiceImpl.getFacilities();

    static {
        Date dateStart1 = null;
        Date dateEnd1 = null;
        Date dateStart2 = null;
        Date dateEnd2 = null;
        Date dateStart3 = null;
        Date dateEnd3 = null;
        Date dateStart4 = null;
        Date dateEnd4 = null;
        Date dateStart5 = null;
        Date dateEnd5 = null;
        try {
            dateStart1 = dateFormat.parse("15-03-2022");
            dateEnd1 = dateFormat.parse("21-03-2022");
            dateStart2 = dateFormat.parse("16-03-2023");
            dateEnd2 = dateFormat.parse("22-03-2023");
            dateStart3 = dateFormat.parse("17-03-2024");
            dateEnd3 = dateFormat.parse("23-03-2025");
            dateStart4 = dateFormat.parse("18-03-2024");
            dateEnd4 = dateFormat.parse("24-03-2025");
            dateStart5 = dateFormat.parse("19-03-2024");
            dateEnd5 = dateFormat.parse("25-03-2025");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Booking booking1 = new Booking("1", dateStart1, dateEnd1, "1", "Villa", "1");
        Booking booking2 = new Booking("3", dateStart3, dateEnd3, "3", "Room", "3");
        Booking booking3 = new Booking("2", dateStart2, dateEnd2, "2", "House", "2");
        Booking booking5 = new Booking("5", dateStart5, dateEnd5, "3", "Villa", "1");
        Booking booking4 = new Booking("4", dateStart4, dateEnd4, "2", "House", "2");
        bookings.add(booking1);
        bookings.add(booking3);
        bookings.add(booking2);
        bookings.add(booking5);
        bookings.add(booking4);

        FileService.writeBooking(FILE_NAME_BOOKING, bookings);

    }

    public static Set<Booking> getBookings() {
        bookings = FileService.readListBookingFromFile(FILE_NAME_BOOKING);
        return bookings;
    }

    @Override
    public void addNewBooking() {
        bookings = FileService.readListBookingFromFile(FILE_NAME_BOOKING);
        System.out.print("Enter booking id: ");
        String id = sc.nextLine();
        System.out.print("Enter date start (dd-MM-yyyy): ");
        Date dateStart = null;
        dateStart = CheckException.checkExForDate(dateStart);
        System.out.print("Enter date end (dd-MM-yyyy): ");
        Date dateEnd = null;
        dateEnd = CheckException.checkExForDate(dateEnd);
        System.out.println("Choice customer id");
        String customerId = choiceListCustomer().getId();

        System.out.println("Choice service id: ");
        String serviceId = choiceService().getServiceId();

        String serviceName = null;
        for (Facility facility: facilities) {
            if (facility.getServiceId().equals(serviceId)) {
                serviceName = facility.getServiceName();
            }
        }
        Booking booking = new Booking(id, dateStart, dateEnd, customerId, serviceName, serviceId);
        bookings.add(booking);
        FileService.writeBooking(FILE_NAME_BOOKING,bookings);

    }

    @Override
    public void displayListBooking() {
        bookings = FileService.readListBookingFromFile(FILE_NAME_BOOKING);
        for (Booking booking: bookings) {
            System.out.println(booking);
        }
    }

    @Override
    public void deleteBooking(Booking b) {
        bookings = FileService.readListBookingFromFile(FILE_NAME_BOOKING);
        bookings.remove(b);
    }

    public Facility choiceService() {
        do {
            for (int i = 0; i < facilities.size(); i++) {
                System.out.println((i + 1) + ". " + "Service id: " + facilities.get(i).getServiceId() + " - " + facilities.get(i).getServiceName());
            }
            System.out.print("Your choice: ");
            int choice = 0;
            choice = CheckException.checkExForParseInt(choice);
            if (choice > 0 && choice <= facilities.size()) {
                facilityService.add(facilities.get(choice - 1));
                return facilities.get(choice - 1);
            } else {
                System.out.println("Choice again!");
            }
        } while (true);
    }

    public Customer choiceListCustomer() {
        List<Customer> customers = FileService.readListCustomerFromFile(FILE_NAME_CUSTOMER);

        do {
            System.out.println("Customer list");
            for (int i = 0; i < customers.size(); i++) {
                System.out.println((i + 1) + ". " + "ID: " + customers.get(i).getId() + " - " + "Name: " + customers.get(i).getName());
            }
            System.out.print("Your choice: ");
            int choice = 0;
            choice = CheckException.checkExForParseInt(choice);
            if (choice > 0 && choice <= customers.size()) {
                System.out.println(customers.size());
                return customers.get(choice - 1);
            } else {
                System.out.println("Choice again!");
            }
        } while (true);
    }
}
