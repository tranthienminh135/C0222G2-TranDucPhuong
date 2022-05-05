package phuong.case_study.furama_manager.sevice.impl;

import phuong.case_study.furama_manager.common.CheckException;
import phuong.case_study.furama_manager.model.booking.Booking;
import phuong.case_study.furama_manager.model.person.Customer;
import phuong.case_study.furama_manager.sevice.BookingService;
import phuong.case_study.furama_manager.sevice.PromotionService;

import java.text.SimpleDateFormat;
import java.util.*;

public class PromotionServiceImpl implements PromotionService {
    private final static String PATTERN = "yyyy";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
    private static Scanner sc = new Scanner(System.in);
    private static Integer countOfVoucher10Percent = 0;
    private static Integer countOfVoucher20Percent = 0;
    private static Integer countOfVoucher50Percent = 0;
    private static BookingService bookingService = new BookingServiceImpl();
    private static Set<Booking> bookingSet = BookingServiceImpl.getBookings();
    private static Integer totalOfVoucher = CustomerServiceImpl.getCustomers().size();
    private static List<Customer> customerList = CustomerServiceImpl.getCustomers();


    static {
    }

    @Override
    public void displayListCustomersUseService() {
        Set<Booking> bookingList = BookingServiceImpl.getBookings();
        boolean check = false;

        System.out.print("Enter year: ");
        String year = sc.nextLine();

        for (Booking booking : bookingList) {
            if (dateFormat.format(booking.getDateEnd()).equals(year)) {
                check = true;
                break;
            }
        }

        if (check) {
            for (Booking booking : bookingList) {
                if (dateFormat.format(booking.getDateEnd()).equals(year)) {
                    System.out.println(booking);
                }
            }
        } else {
            System.out.println("In " + year + " no one used the service");
        }
    }

    @Override
    public void giveAwayVoucher() {
        if (totalOfVoucher >= 1) {
            for (Booking booking : bookingSet) {
                if (countOfVoucher50Percent > 0) {
                    System.out.println("Customer with id: " + booking.getCustomerID() + " will be give away " + 1 + " voucher 50%");
                    countOfVoucher50Percent--;
                } else if (countOfVoucher20Percent > 0) {
                    System.out.println("Customer with id: " + booking.getCustomerID() + " will be give away " + 1 + " voucher 20%");
                    countOfVoucher20Percent--;
                } else if (countOfVoucher10Percent > 0) {
                    System.out.println("Customer with id: " + booking.getCustomerID() + " will be give away " + 1 + " voucher 10%");
                    countOfVoucher10Percent--;
                }
            }
        } else {
            System.err.println("Voucher is not enough!");
        }
    }

    @Override
    public void voucher() {
        System.out.print("Enter count of voucher (10%): ");
        int count10Percent = 0;
        count10Percent = CheckException.checkExForParseInt(count10Percent);
        System.out.print("Enter count of voucher (20%): ");
        int count20Percent = 0;
        count20Percent = CheckException.checkExForParseInt(count20Percent);
        System.out.print("Enter count of voucher (50%): ");
        int count50Percent = 0;
        count50Percent = CheckException.checkExForParseInt(count50Percent);

        while ((count10Percent + count20Percent + count50Percent) > totalOfVoucher) {
            System.err.println("The total number of voucher cannot be greater than the total number of customers");
            System.out.println();
            System.out.print("Enter count of voucher (10%): ");
            count10Percent = Integer.parseInt(sc.nextLine());
            System.out.print("Enter count of voucher (20%): ");
            count20Percent = Integer.parseInt(sc.nextLine());
            System.out.print("Enter count of voucher (50%): ");
            count50Percent = Integer.parseInt(sc.nextLine());
        }
        countOfVoucher10Percent = count10Percent;
        countOfVoucher20Percent = count20Percent;
        countOfVoucher50Percent = count50Percent;

        giveAwayVoucher();
    }
}
