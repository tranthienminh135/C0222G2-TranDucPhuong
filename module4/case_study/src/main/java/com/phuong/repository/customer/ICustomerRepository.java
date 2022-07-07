package com.phuong.repository.customer;

import com.phuong.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = " select * from customer where name like :searchParam ", nativeQuery = true,
            countQuery = " select count(*) from (select * from customer where name like :searchParam) temp_table ")
    Page<Customer> getAllCustomer(Pageable pageable,@Param("searchParam") String searchParam);
}
