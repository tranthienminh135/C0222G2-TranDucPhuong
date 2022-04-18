package phuong.case_study.furama_manager.sevice.impl;

import phuong.case_study.furama_manager.model.person.Employee;
import phuong.case_study.furama_manager.sevice.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static Scanner sc = new Scanner(System.in);
    private static List<Employee> employees = new ArrayList<>();

    static {
        Employee employee1 = new Employee("1","Le Van Tai", "15-03-2022","Male",187422600L,
                84533950234L,"levantai@gmail.com", "Dai Hoc", "Giam Doc", 100000d);

        Employee employee2 = new Employee("2","Tran Van Hoan", "19-04-1990","Male",14564600L,
                84533950234L,"tranvanhoan@gmail.com", "Cao Dang", "Le tan", 456600d);

        Employee employee3 = new Employee("3","Tra Van Luan", "17-12-2012","Male",1456600L,
                84533950234L,"travanluan@gmail.com", "Trung Cap", "Giam sat", 456000d);

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

    }

    @Override
    public void add() {
        System.out.print("Enter id: ");
        String id = sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter date: ");
        String date = sc.nextLine();
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter idCard: ");
        long idCard = Long.parseLong(sc.nextLine());
        System.out.print("Enter phone number: ");
        long phoneNumber = Long.parseLong(sc.nextLine());
        System.out.print("Enter mail: ");
        String mail = sc.nextLine();
        System.out.print("Enter level: ");
        String level = sc.nextLine();
        System.out.print("Enter position: ");
        String position = sc.nextLine();
        System.out.print("Enter salary: ");
        double salary = Double.parseDouble(sc.nextLine());

        Employee employee = new Employee(id,name,date,gender,idCard,phoneNumber,mail,level,position,salary);

        employees.add(employee);
    }

    @Override
    public void display() {
        for (Employee employee: employees) {
            System.out.println(employee);
        }
    }

    @Override
    public void edit() {
        System.out.print("Enter id for edit: ");
        String id = sc.nextLine();

        if (checkIdExists(id)) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter date: ");
            String date = sc.nextLine();
            System.out.print("Enter gender: ");
            String gender = sc.nextLine();
            System.out.print("Enter idCard: ");
            long idCard = Long.parseLong(sc.nextLine());
            System.out.print("Enter phone number: ");
            long phoneNumber = Long.parseLong(sc.nextLine());
            System.out.print("Enter mail: ");
            String mail = sc.nextLine();
            System.out.print("Enter level: ");
            String level = sc.nextLine();
            System.out.print("Enter position: ");
            String position = sc.nextLine();
            System.out.print("Enter salary: ");
            double salary = Double.parseDouble(sc.nextLine());
            for (Employee employee: employees) {
                if (employee.getId().equals(id)) {
                    employee.setId(id);
                    employee.setName(name);
                    employee.setDate(date);
                    employee.setGender(gender);
                    employee.setIdCard(idCard);
                    employee.setPhoneNumber(phoneNumber);
                    employee.setMail(mail);
                    employee.setLevel(level);
                    employee.setPosition(position);
                    employee.setSalary(salary);
                    break;
                }
            }
        } else {
            System.out.println("Id is NOT found!");
        }


    }

    @Override
    public boolean checkIdExists(String id) {
        for (Employee e: employees) {
            if (e.getId().contains(id)) {
                return true;
            }
        }
        return false;
    }


}
