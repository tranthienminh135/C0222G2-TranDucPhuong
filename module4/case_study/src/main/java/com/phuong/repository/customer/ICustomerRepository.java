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

    @Query(value = " select c.* from customer c " +
            " left join contract c2 on c.id = c2.customer_id " +
            " left join contract_detail cd on c2.id = cd.contract_id " +
            " left join facility f on c2.facility_id = f.id " +
            " left join contract_detail d on c2.id = d.contract_id " +
            " left join attach_facility af on af.id = cd.attach_facility_id " +
            " group by c.id, f.id ", nativeQuery = true,
            countQuery = " select c.* from customer c " +
                    " left join contract c2 on c.id = c2.customer_id " +
                    " left join contract_detail cd on c2.id = cd.contract_id " +
                    " left join facility f on c2.facility_id = f.id " +
                    " left join contract_detail d on c2.id = d.contract_id " +
                    " left join attach_facility af on af.id = cd.attach_facility_id " +
                    " group by c.id, f.id ")
    Page<Customer> findCustomerUsingFacility(Pageable pageable);
}
