package phuong.case_study.furama_manager.sevice.impl;

import phuong.case_study.furama_manager.model.booking.Booking;
import phuong.case_study.furama_manager.model.booking.Contract;
import phuong.case_study.furama_manager.sevice.BookingService;
import phuong.case_study.furama_manager.sevice.ContactService;

import java.util.*;

public class ContactServiceImpl implements ContactService {
    private static Scanner sc = new Scanner(System.in);
    private static Queue<Booking> bookingQueue = new PriorityQueue<>();
    private static List<Contract> contracts = new ArrayList<>();
    private static BookingService bookingService = new BookingServiceImpl();

    static {
        Set<Booking> bookingSet = BookingServiceImpl.getBookingService();

        for (Booking booking : bookingSet) {
            bookingQueue.offer(booking);
        }
    }


    @Override
    public void createNewContract() {
        if (!bookingQueue.isEmpty()) {
            System.out.print("Enter contract id: ");
            String contractId = sc.nextLine();
            String bookingId = bookingQueue.element().getBookingId();
            System.out.print("Enter deposit: ");
            long deposit = Long.parseLong(sc.nextLine());
            System.out.print("Enter total money: ");
            long totalMoney = Long.parseLong(sc.nextLine());
            String customerId = bookingQueue.element().getCustomerID();
            bookingService.deleteBooking(bookingQueue.element());
            bookingQueue.poll();
            Contract contract = new Contract(contractId, bookingId, deposit, totalMoney, customerId);
            contracts.add(contract);
        } else {
            System.err.println("Booking list is empty!");
        }


    }

    @Override
    public void displayListContract() {
        for (Contract contract: contracts) {
            System.out.println(contract);
        }
    }

    @Override
    public void editContract() {
        boolean flag = false;
        System.out.print("Choice contract id: ");
        String id = sc.nextLine();
        if (!contracts.isEmpty()) {
            for (int i = 0; i < contracts.size(); i++) {
                if (contracts.get(i).getContractId().equals(id)) {
                    flag = true;
                    break;
                }
            }
        } else {
            System.err.println("List contract is empty!");
        }

        if (flag) {
            for (int i = 0; i < contracts.size(); i++) {
                if (contracts.get(i).getContractId().equals(id)) {
                    contracts.get(i).setContractId(id);
                    System.out.print("Enter new deposits: ");
                    contracts.get(i).setDeposits(Long.parseLong(sc.nextLine()));
                    System.out.print("Enter new totalMoney: ");
                    contracts.get(i).setTotalMoney(Long.parseLong(sc.nextLine()));
                    break;
                }
            }
        } else {
            System.err.println("Contract id is not found!");
        }
    }

    public static void main(String[] args) {
        System.out.println("before");
        for (Booking b : ContactServiceImpl.bookingQueue) {
            System.out.println(b);
        }
        ContactService contactService = new ContactServiceImpl();
        contactService.createNewContract();
        contactService.createNewContract();

        System.out.println("------------");
        System.out.println("after");
        for (Booking b : ContactServiceImpl.bookingQueue) {
            System.out.println(b);
        }
        System.out.println("------------");

        for (Contract c : ContactServiceImpl.contracts) {
            System.out.println(c);
        }

        System.out.println("------------");

        for (Booking b : BookingServiceImpl.getBookingService()) {
            System.out.println(b);
        }
    }
}
