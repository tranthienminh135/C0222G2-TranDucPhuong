package com.phuong.service.customer_type.impl;

import com.phuong.model.customer.CustomerType;
import com.phuong.repository.customer_type.ICustomerTypeRepository;
import com.phuong.service.customer_type.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return this.customerTypeRepository.findAll();
    }
}
