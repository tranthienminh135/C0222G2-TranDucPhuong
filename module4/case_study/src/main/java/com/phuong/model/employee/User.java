package com.phuong.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    private String username;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoleList;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Employee> employeeList;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, List<UserRole> userRoleList, List<Employee> employeeList) {
        this.username = username;
        this.password = password;
        this.userRoleList = userRoleList;
        this.employeeList = employeeList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
