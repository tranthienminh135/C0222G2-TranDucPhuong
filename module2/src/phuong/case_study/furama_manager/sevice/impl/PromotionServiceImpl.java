package phuong.case_study.furama_manager.sevice.impl;

import phuong.case_study.furama_manager.model.booking.Booking;
import phuong.case_study.furama_manager.sevice.PromotionService;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Set;

public class PromotionServiceImpl implements PromotionService {
    private final static String PATTERN = "yyyy";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
    private static Scanner sc = new Scanner(System.in);
    private static Integer countOfVoucher10Percent;
    private static Integer countOfVoucher20Percent;
    private static Integer countOfVoucher50Percent;

    public static void main(String[] args) {

    }


    @Override
    public void displayListCustomersUseService() {
        Set<Booking> bookingList = BookingServiceImpl.getBookingService();


        System.out.print("Enter year: ");
        String year = sc.nextLine();
        for (Booking booking : bookingList) {
            if (dateFormat.format(booking.getDateEnd()).equals(year)) {
                System.out.println(booking);
            }
        }
    }
    public void voucher() {
        System.out.print("Choice voucher: " + "\n" +
                "1. Voucher 10%" + "\n" +
                "2. Voucher 20%" + "\n" +
                "3. Voucher 50%" + "\n");
        int choiceVoucher = Integer.parseInt(sc.nextLine());
        switch (choiceVoucher) {
            case 1:
                System.out.print("Enter count of voucher (10%): ");
                countOfVoucher10Percent = Integer.valueOf(sc.nextLine());
                break;
            case 2:
                System.out.print("Enter count of voucher (20%): ");
                countOfVoucher20Percent = Integer.valueOf(sc.nextLine());
                break;
            case 3:
                System.out.print("Enter count of voucher (50%): ");
                countOfVoucher50Percent = Integer.valueOf(sc.nextLine());
                break;
        }
    }
}
