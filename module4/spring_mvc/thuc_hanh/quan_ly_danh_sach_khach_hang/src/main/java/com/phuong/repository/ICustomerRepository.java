package com.phuong.repository;

import com.phuong.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAllCustomer();

    void deleteCustomer(String idDelete);

    void addNewCustomer(Customer customer);

    Customer getCustomerForEdit(String idEdit);

    void editCustomer(Customer customer);
}
