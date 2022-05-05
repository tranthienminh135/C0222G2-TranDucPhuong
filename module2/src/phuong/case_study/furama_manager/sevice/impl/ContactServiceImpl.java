package phuong.case_study.furama_manager.sevice.impl;

import phuong.case_study.furama_manager.common.CheckException;
import phuong.case_study.furama_manager.common.FileService;
import phuong.case_study.furama_manager.model.booking.Booking;
import phuong.case_study.furama_manager.model.booking.Contract;
import phuong.case_study.furama_manager.sevice.BookingService;
import phuong.case_study.furama_manager.sevice.ContactService;

import java.util.*;

public class ContactServiceImpl implements ContactService {
    private final static String FILE_NAME_CONTRACT = "src/phuong/case_study/furama_manager/common/data/contract.csv";
    private static Scanner sc = new Scanner(System.in);
    private static Queue<Booking> bookingQueue = new PriorityQueue<>();
    private static List<Contract> contracts = new ArrayList<>();
    private static BookingService bookingService = new BookingServiceImpl();

    static {
        Set<Booking> bookingSet = BookingServiceImpl.getBookings();

        for (Booking booking : bookingSet) {
            bookingQueue.offer(booking);
        }
    }


    @Override
    public void createNewContract() {
        contracts = FileService.readListContractFromFile(FILE_NAME_CONTRACT);
        if (!bookingQueue.isEmpty()) {
            System.out.print("Enter contract id: ");
            String contractId = sc.nextLine();
            String bookingId = bookingQueue.element().getBookingId();
            System.out.print("Enter deposit: ");
            long deposit = 0;
            deposit = CheckException.checkExForParseLong(deposit);
            System.out.print("Enter total money: ");
            long totalMoney = 0;
            totalMoney = CheckException.checkExForParseLong(totalMoney);
            String customerId = bookingQueue.element().getCustomerID();
            bookingService.deleteBooking(bookingQueue.element());
            bookingQueue.poll();
            Contract contract = new Contract(contractId, bookingId, deposit, totalMoney, customerId);
            contracts.add(contract);
            FileService.writeContract(FILE_NAME_CONTRACT, contracts);
        } else {
            System.err.println("Booking list is empty!");
        }
    }

    @Override
    public void displayListContract() {
        contracts = FileService.readListContractFromFile(FILE_NAME_CONTRACT);
        for (Contract contract : contracts) {
            System.out.println(contract);
        }
    }

    @Override
    public void editContract() {
        contracts = FileService.readListContractFromFile(FILE_NAME_CONTRACT);
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
            return;
        }

        if (flag) {
            for (int i = 0; i < contracts.size(); i++) {
                if (contracts.get(i).getContractId().equals(id)) {
                    contracts.get(i).setContractId(id);
                    System.out.print("Enter new deposits: ");
                    long deposit = 0;
                    deposit = CheckException.checkExForParseLong(deposit);
                    contracts.get(i).setDeposits(deposit);
                    System.out.print("Enter new totalMoney: ");
                    long totalMoney = 0;
                    totalMoney = CheckException.checkExForParseLong(totalMoney);
                    contracts.get(i).setTotalMoney(totalMoney);
                    break;
                }
            }
            FileService.writeContract(FILE_NAME_CONTRACT, contracts);
        } else {
            System.err.println("Contract id is not found!");
        }
    }
}
