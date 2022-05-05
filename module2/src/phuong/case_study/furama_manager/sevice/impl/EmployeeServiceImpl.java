package phuong.case_study.furama_manager.sevice.impl;

import phuong.case_study.furama_manager.common.CheckException;
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

    @Override
    public void add() {
        employees = FileService.readListEmployeeFromFile(FILE_NAME_EMPLOYEE);
        System.out.print("Enter id: ");
        String id = sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter day of birth (dd-MM-yyyy): ");
        Date dateAdd = null;
        dateAdd = CheckException.checkExForDayOfBirth(dateAdd);
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
        System.out.print("Enter level: ");
        String level = sc.nextLine();
        System.out.print("Enter position: ");
        String position = sc.nextLine();
        System.out.print("Enter salary: ");
        double salary = 0;
        salary = CheckException.checkExForParseDouble(salary);

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
            dateEdit = CheckException.checkExForDayOfBirth(dateEdit);
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
            System.out.print("Enter level: ");
            String level = sc.nextLine();
            System.out.print("Enter position: ");
            String position = sc.nextLine();
            System.out.print("Enter salary: ");
            double salary = 0;
            salary = CheckException.checkExForParseDouble(salary);
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
