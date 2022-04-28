package phuong.case_study.furama_manager.sevice.impl;

import phuong.case_study.furama_manager.common.CheckEx;
import phuong.case_study.furama_manager.common.FileService;
import phuong.case_study.furama_manager.model.person.Employee;
import phuong.case_study.furama_manager.sevice.EmployeeService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private final static String FILE_NAME_EMPLOYEE = "src/phuong/case_study/furama_manager/common/data/employee.csv";
    private static Scanner sc = new Scanner(System.in);
    private static List<Employee> employees = new ArrayList<>();
    private final static String PATTERN = "dd-MM-yyyy";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);

    static {

        Date date1 = null;
        Date date2 = null;
        Date date3 = null;
        try {
            date1 = dateFormat.parse("15-03-2022");
            date2 = dateFormat.parse("21-03-2022");
            date3 = dateFormat.parse("16-03-2022");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Employee employee1 = new Employee("1", "Le Van Tai", date1, "Male", 187422600L,
                84533950234L, "levantai@gmail.com", "Dai Hoc", "Giam Doc", 100000d);

        Employee employee2 = new Employee("2", "Tran Van Hoan", date2, "Male", 14564600L,
                84533950234L, "tranvanhoan@gmail.com", "Cao Dang", "Le tan", 456600d);

        Employee employee3 = new Employee("3", "Tra Van Luan", date3, "Male", 1456600L,
                84533950234L, "travanluan@gmail.com", "Trung Cap", "Giam sat", 456000d);

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        FileService.writeEmployee(FILE_NAME_EMPLOYEE, employees);
    }

    @Override
    public void add() {
        employees = FileService.readListEmployeeFromFile(FILE_NAME_EMPLOYEE);
        System.out.print("Enter id: ");
        String id = sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter day of birth (dd-MM-yyyy): ");
        Date dateAdd = null;
        dateAdd = CheckEx.checkExForDayOfBirth(dateAdd);
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
        System.out.print("Enter level: ");
        String level = sc.nextLine();
        System.out.print("Enter position: ");
        String position = sc.nextLine();
        System.out.print("Enter salary: ");
        double salary = 0;
        salary = CheckEx.checkExForParseDouble(salary);

        Employee employee = new Employee(id, name, dateAdd, gender, idCard, phoneNumber, mail, level, position, salary);

        employees.add(employee);
        FileService.writeEmployee(FILE_NAME_EMPLOYEE, employees);
    }

    @Override
    public void display() {
        employees = FileService.readListEmployeeFromFile(FILE_NAME_EMPLOYEE);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Override
    public void edit() {
        employees = FileService.readListEmployeeFromFile(FILE_NAME_EMPLOYEE);
        System.out.print("Enter id for edit: ");
        String id = sc.nextLine();

        if (checkIdExists(id)) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter day of birth: ");
            Date dateEdit = null;
            dateEdit = CheckEx.checkExForDayOfBirth(dateEdit);
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
            System.out.print("Enter level: ");
            String level = sc.nextLine();
            System.out.print("Enter position: ");
            String position = sc.nextLine();
            System.out.print("Enter salary: ");
            double salary = 0;
            salary = CheckEx.checkExForParseDouble(salary);
            for (Employee employee : employees) {
                if (employee.getId().equals(id)) {
                    employee.setId(id);
                    employee.setName(name);
                    employee.setDayOfBirth(dateEdit);
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
            FileService.writeEmployee(FILE_NAME_EMPLOYEE, employees);
        } else {
            System.out.println(id + " is NOT found!");
        }
    }

    @Override
    public boolean checkIdExists(String id) {
        employees = FileService.readListEmployeeFromFile(FILE_NAME_EMPLOYEE);
        for (Employee e : employees) {
            if (e.getId().contains(id)) {
                return true;
            }
        }
        return false;
    }
}
