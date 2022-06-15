package com.phuong.service.impl;

import com.phuong.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.phuong.repository.ICustomerRepository;
import com.phuong.service.ICustomerService;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }

    @Override
    public void deleteCustomer(String idDelete) {
        customerRepository.deleteCustomer(idDelete);
    }

    @Override
    public void addNewCustomer(Customer customer) {
        customerRepository.addNewCustomer(customer);
    }

    @Override
    public Customer getCustomerForEdit(String idEdit) {
        return customerRepository.getCustomerForEdit(idEdit);
    }

    @Override
    public void editCustomer(Customer customer) {
        customerRepository.editCustomer(customer);
    }
}
