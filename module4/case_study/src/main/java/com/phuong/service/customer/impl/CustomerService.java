package com.phuong.service.customer.impl;

import com.phuong.model.customer.Customer;
import com.phuong.repository.customer.ICustomerRepository;
import com.phuong.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable, String searchParam) {
        return this.customerRepository.getAllCustomer(pageable, "%" + searchParam + "%");
    }

    @Override
    public void delete(String idEdit) {
        this.customerRepository.delete(this.customerRepository.getById(Integer.valueOf(idEdit)));
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public Customer getById(String idEdit) {
        return this.customerRepository.getById(Integer.valueOf(idEdit));
    }
}
