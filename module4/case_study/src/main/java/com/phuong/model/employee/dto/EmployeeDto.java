package com.phuong.model.employee.dto;

import com.phuong.model.contract.Contract;
import com.phuong.model.employee.Division;
import com.phuong.model.employee.EducationDegree;
import com.phuong.model.employee.Employee;
import com.phuong.model.employee.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EmployeeDto implements Validator {
    private Integer id;

    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$", message = "invalidName")
    private String name;

    private Date birthday;

    @Pattern(regexp = "([1-9][0-9]{8})|([1-9][0-9]{11})", message = "invalidIdCard")
    private String idCard;

    private String phoneNumber;

    private String email;

    private String address;

    private Double salary;

    private EducationDegree educationDegree;

    private Position position;

    private Division division;

    private List<Contract> contractList;

    private List<Employee> employeeList;

    private List<String> idCardList;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String name, Date birthday, String idCard, String phoneNumber, String email,
                       String address, Double salary, EducationDegree educationDegree,
                       Position position, Division division, List<Contract> contractList,
                       List<Employee> employeeList, List<String> idCardList) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.educationDegree = educationDegree;
        this.position = position;
        this.division = division;
        this.contractList = contractList;
        this.employeeList = employeeList;
        this.idCardList = idCardList;
    }

    public List<String> getIdCardList() {
        return idCardList;
    }

    public void setIdCardList(List<String> idCardList) {
        this.idCardList = idCardList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        List<Employee> employeeList = this.getEmployeeList();
        List<String> idCardList = this.getIdCardList();
        if (!idCardList.isEmpty()) {
            for (String idCard: idCardList) {
                if (employeeDto.getIdCard().equals(idCard)) {
                    errors.rejectValue("idCard", "", "idCardExists");
                }
            }
        }
        if (!employeeList.isEmpty()) {
            for (Employee employee: employeeList) {
                if (employee.getEmail().equals(employeeDto.getEmail())) {
                    errors.rejectValue("email", "", "emailExists!");
                    break;
                }
            }
        }
        String pattern = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate birthday = LocalDate.parse(employeeDto.getBirthday().toString(), formatter);
        LocalDate now = LocalDate.now();
        int age = Period.between(birthday, now).getYears();
        if (age < 18) {
            errors.rejectValue("birthday", "", "age18");
        }
    }
}
