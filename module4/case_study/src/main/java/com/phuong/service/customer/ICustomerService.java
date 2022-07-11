package com.phuong.service.customer;

import com.phuong.model.customer.Customer;
import com.phuong.model.customer.CustomerAndAttachFacilityDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable, String searchParam);

    void delete(String idEdit);

    void save(Customer customer);

    Customer getById(String idEdit);

    List<Customer> findAll();

    Page<Customer> findCustomerUsingFacility(Pageable pageable);

    Page<CustomerAndAttachFacilityDto> getCustomerAndAF(Pageable pageable);
}
