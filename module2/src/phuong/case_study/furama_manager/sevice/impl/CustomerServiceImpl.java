package phuong.case_study.furama_manager.sevice.impl;

import phuong.case_study.furama_manager.common.CheckEx;
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

    static {

        Date date1 = null;
        Date date2 = null;
        Date date3 = null;
        Date date4 = null;
        Date date5 = null;
        try {
            date1 = dateFormat.parse("15-03-2022");
            date2 = dateFormat.parse("21-03-2022");
            date3 = dateFormat.parse("16-03-2022");
            date4 = dateFormat.parse("22-03-2022");
            date5 = dateFormat.parse("17-03-2022");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Customer customer1 = new Customer("1","Hau",date1,"Male",187546243L,
                84321562345L,"hau123@gmail.com","Diamond","QN");

        Customer customer2 = new Customer("2","Luan",date2,"Female",358462132L,
                84213591357L,"luandn@gmail.com","Platinium","DN");

        Customer customer3 = new Customer("3","Tai",date3,"Male",652455131L,
                84896535154L,"taichodien@gmail.com","Gold","TH");

        Customer customer4 = new Customer("4","Tri",date4,"Female",321562489L,
                84687562134L,"trithitbo@gmail.com","Silver","QT");

        Customer customer5 = new Customer("5","Hoan",date5,"Male",35448135L,
                84262358621L,"hoanngaoda@gmail.com","Member","GL");

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);

        FileService.writeCustomer(FILE_NAME,customers);
    }

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
        date = CheckEx.checkExForDayOfBirth(date);
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter idCard: ");
        long idCard = 0;
        idCard = CheckEx.checkExForParseLong(idCard);
        System.out.print("Enter phone number: ");
        long phoneNumber = 0;
        phoneNumber = CheckEx.checkExForParseLong(phoneNumber);
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
            date = CheckEx.checkExForDayOfBirth(date);
            System.out.print("Enter gender: ");
            String gender = sc.nextLine();
            System.out.print("Enter idCard: ");
            long idCard = 0;
            idCard = CheckEx.checkExForParseLong(idCard);
            System.out.print("Enter phone number: ");
            long phoneNumber = 0;
            phoneNumber = CheckEx.checkExForParseLong(phoneNumber);
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
