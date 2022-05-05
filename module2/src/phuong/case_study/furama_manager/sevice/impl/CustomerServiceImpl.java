package phuong.case_study.furama_manager.sevice.impl;

import phuong.case_study.furama_manager.common.CheckException;
import phuong.case_study.furama_manager.common.FileService;
import phuong.case_study.furama_manager.model.person.Customer;
import phuong.case_study.furama_manager.sevice.CustomerService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private final static String FILE_NAME = "src/phuong/case_study/furama_manager/common/data/customer.csv";
    private static Scanner sc = new Scanner(System.in);
    private static List<Customer> customers = new LinkedList<>();
    private final static String PATTERN = "dd-MM-yyyy";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);

    public static List<Customer> getCustomers() {
        customers = FileService.readListCustomerFromFile(FILE_NAME);
        return customers;
    }

    @Override
    public void add() {
        customers = FileService.readListCustomerFromFile(FILE_NAME);
        System.out.print("Enter id: ");
        String id = sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter day of birth: ");
        Date date = null;
        date = CheckException.checkExForDayOfBirth(date);
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter idCard: ");
        long idCard = 0;
        idCard = CheckException.checkExForParseLong(idCard);
        System.out.print("Enter phone number: ");
        long phoneNumber = 0;
        phoneNumber = CheckException.checkExForParseLong(phoneNumber);
        System.out.print("Enter mail: ");
        String mail = sc.nextLine();
        System.out.print("Enter rank: ");
        String rank = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();

        Customer customer = new Customer(id,name,date,gender,idCard,phoneNumber,mail,rank,address);

        customers.add(customer);
        FileService.writeCustomer(FILE_NAME,customers);
    }

    @Override
    public void display() {
        customers = FileService.readListCustomerFromFile(FILE_NAME);
        for (Customer customer: customers) {
            System.out.println(customer);
        }

    }

    @Override
    public void edit() {
        customers = FileService.readListCustomerFromFile(FILE_NAME);
        System.out.print("Enter id for edit: ");
        String id = sc.nextLine();

        if (checkIdExists(id)) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter day of birth: ");
            Date date = null;
            date = CheckException.checkExForDayOfBirth(date);
            System.out.print("Enter gender: ");
            String gender = sc.nextLine();
            System.out.print("Enter idCard: ");
            long idCard = 0;
            idCard = CheckException.checkExForParseLong(idCard);
            System.out.print("Enter phone number: ");
            long phoneNumber = 0;
            phoneNumber = CheckException.checkExForParseLong(phoneNumber);
            System.out.print("Enter mail: ");
            String mail = sc.nextLine();
            System.out.print("Enter rank: ");
            String rank = sc.nextLine();
            System.out.print("Enter address: ");
            String address = sc.nextLine();

            for (Customer customer: customers) {
                if (customer.getId().equals(id)) {
                    customer.setId(id);
                    customer.setName(name);
                    customer.setDayOfBirth(date);
                    customer.setGender(gender);
                    customer.setIdCard(idCard);
                    customer.setPhoneNumber(phoneNumber);
                    customer.setMail(mail);
                    customer.setCustomerRank(rank);
                    customer.setAddress(address);
                    break;
                }
            }
            FileService.writeCustomer(FILE_NAME,customers);
        } else {
            System.out.println(id + " is NOT found!");
        }
    }

    @Override
    public boolean checkIdExists(String id) {
        customers = FileService.readListCustomerFromFile(FILE_NAME);
        for (Customer customer: customers) {
            if (customer.getId().contains(id)) {
                return true;
            }
        }
        return false;
    }
}
