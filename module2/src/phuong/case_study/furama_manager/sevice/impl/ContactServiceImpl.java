package phuong.case_study.furama_manager.sevice.impl;

import phuong.case_study.furama_manager.model.booking.Booking;
import phuong.case_study.furama_manager.model.contract.Contract;
import phuong.case_study.furama_manager.sevice.ContactService;

import java.util.*;

public class ContactServiceImpl implements ContactService {
    private static Queue<Booking> bookingQueue = new PriorityQueue<>();
    private static List<Contract> contracts = new ArrayList<>();

    static {
        Set<Booking> bookingSet = BookingServiceImpl.getBookingService();

        for (Booking booking: bookingSet) {
            bookingQueue.offer(booking);
        }
    }


    @Override
    public void createNewContact() {

    }
}
