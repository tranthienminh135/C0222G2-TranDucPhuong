package com.phuong.model.customer;

import com.phuong.model.contract.Contract;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.List;

public class CustomerDto {
    private Integer id;

    private String address;

    @NotNull(message = "Birthday invalid")
    private Date birthday;

    @Email
    private String email;

    private Integer gender;

    @Pattern(regexp = "^[1-9][0-9]{8}$", message = "Id card invalid")
    private String idCard;

    @Pattern(regexp = "^([A-Za-z]+)$", message = "Name invalid")
    private String name;

    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", message = "Phone number invalid")
    private String phoneNumber;

    private CustomerType customerType;

    private List<Contract> contractList;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String address, Date birthday, String email,
                       Integer gender, String idCard, String name, String phoneNumber,
                       CustomerType customerType, List<Contract> contractList) {
        this.id = id;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
        this.gender = gender;
        this.idCard = idCard;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.customerType = customerType;
        this.contractList = contractList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
