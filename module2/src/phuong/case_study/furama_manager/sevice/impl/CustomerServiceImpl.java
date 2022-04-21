package phuong.case_study.furama_manager.sevice.impl;

import phuong.case_study.furama_manager.model.person.Customer;
import phuong.case_study.furama_manager.sevice.CustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static Scanner sc = new Scanner(System.in);
    private static List<Customer> customers = new LinkedList<>();

    static {
        Customer customer1 = new Customer("1","Hau","19-9-999","Male",187546243L,
                84321562345L,"hau123@gmail.com","Diamond","QN");

        Customer customer2 = new Customer("2","Luan","12-2-222","Female",358462132L,
                84213591357L,"luandn@gmail.com","Platinium","DN");

        Customer customer3 = new Customer("3","Tai","18-8-1666","Male",652455131L,
                84896535154L,"taichodien@gmail.com","Gold","TH");

        Customer customer4 = new Customer("4","Tri","23-6-1234","Female",321562489L,
                84687562134L,"trithitbo@gmail.com","Silver","QT");

        Customer customer5 = new Customer("5","Hoan","16-6-677","Male",35448135L,
                84262358621L,"hoanngaoda@gmail.com","Member","GL");

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
    }

    @Override
    public void add() {
        System.out.print("Enter id: ");
        String id = sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter day of birth: ");
        String date = sc.nextLine();
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter idCard: ");
        long idCard = Long.parseLong(sc.nextLine());
        System.out.print("Enter phone number: ");
        long phoneNumber = Long.parseLong(sc.nextLine());
        System.out.print("Enter mail: ");
        String mail = sc.nextLine();
        System.out.print("Enter rank: ");
        String rank = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();

        Customer customer = new Customer(id,name,date,gender,idCard,phoneNumber,mail,rank,address);

        customers.add(customer);
    }

    @Override
    public void display() {
        for (Customer customer: customers) {
            System.out.println(customer);
        }

    }

    @Override
    public void edit() {
        System.out.print("Enter id for edit: ");
        String id = sc.nextLine();

        if (checkIdExists(id)) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter day of birth: ");
            String date = sc.nextLine();
            System.out.print("Enter gender: ");
            String gender = sc.nextLine();
            System.out.print("Enter idCard: ");
            long idCard = Long.parseLong(sc.nextLine());
            System.out.print("Enter phone number: ");
            long phoneNumber = Long.parseLong(sc.nextLine());
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
        } else {
            System.out.println("Id is NOT found!");
        }
    }

    @Override
    public boolean checkIdExists(String id) {
        for (Customer customer: customers) {
            if (customer.getId().contains(id)) {
                return true;
            }
        }
        return false;
    }
}
