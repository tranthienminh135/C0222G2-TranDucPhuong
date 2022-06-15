package com.phuong.service;

import com.phuong.model.Customer;

import java.util.List;
public interface ICustomerService {
    List<Customer> getAllCustomer();

    void deleteCustomer(String idDelete);

    void addNewCustomer(Customer customer);

    Customer getCustomerForEdit(String idEdit);

    void editCustomer(Customer customer);
}
