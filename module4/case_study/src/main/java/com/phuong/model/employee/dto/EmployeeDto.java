package com.phuong.model.employee.dto;

import com.phuong.model.contract.Contract;
import com.phuong.model.employee.Division;
import com.phuong.model.employee.EducationDegree;
import com.phuong.model.employee.Position;
import com.phuong.model.employee.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.List;

public class EmployeeDto implements Validator {
    private Integer id;

    @Pattern(regexp = "^[A-Za-z]+$", message = "Name invalid")
    private String name;

    private Date birthday;

    private String idCard;

    private String phoneNumber;

    private String email;

    private String address;

    private Double salary;

    private EducationDegree educationDegree;

    private Position position;

    private Division division;

    private User user;

    private List<Contract> contractList;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String name, Date birthday, String idCard, String phoneNumber, String email,
                       String address, Double salary, EducationDegree educationDegree, Position position,
                       Division division, User user, List<Contract> contractList) {
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
        this.user = user;
        this.contractList = contractList;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (employeeDto.salary < 1000) {
            errors.rejectValue("errSalary", "Salary < 1000");
        }
    }
}
