package com.phuong.repository.customer;

import com.phuong.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<CustomerType, Integer> {
}
