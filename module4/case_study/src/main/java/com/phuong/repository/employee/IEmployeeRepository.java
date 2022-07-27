package com.phuong.repository.employee;

import com.phuong.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = " select * from employee where name like :searchParam and is_deleted = 0 ", nativeQuery = true,
            countQuery = " select count(*) from (select * from employee where name like :searchParam and is_deleted = 0 ) temp_table ")
    Page<Employee> findAll(Pageable pageable,@Param("searchParam") String searchParam);

    @Query(value = " select * from employee where id = :idEdit and is_deleted = 0 ", nativeQuery = true)
    Employee findById(@Param("idEdit") String idEdit);

    @Query(value = " select * from employee where is_deleted = 0 ", nativeQuery = true)
    List<Employee> findAllEmployee();
}
