package com.phuong.model.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.phuong.model.contract.Contract;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String address;

    private Date birthday;

    private String email;

    private Integer gender;

    private String idCard;

    private String name;

    private String phoneNumber;
    
    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private List<Contract> contractList;

    public Customer() {
    }

    public Customer(Integer id, String address, Date birthday, String email, Integer gender, String idCard,
                    String name, String phoneNumber, CustomerType customerType, List<Contract> contractList) {
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", idCard='" + idCard + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", customerType=" + customerType +
                ", contractList=" + contractList +
                '}';
    }
}
