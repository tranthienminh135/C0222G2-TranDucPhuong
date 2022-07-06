package com.phuong.service.customer.impl;

import com.phuong.model.customer.CustomerType;
import com.phuong.repository.customer.ICustomerRepository;
import com.phuong.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<CustomerType> findAll() {
        return this.customerRepository.findAll();
    }
}
