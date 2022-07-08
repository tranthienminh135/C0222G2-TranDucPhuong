package com.phuong.repository.employee;

import com.phuong.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = " select * from employee where name like :searchParam ", nativeQuery = true,
            countQuery = " select count(*) from (select * from employee where name like :searchParam) temp_table ")
    Page<Employee> findAll(Pageable pageable,@Param("searchParam") String searchParam);

    @Modifying
    @Transactional
    @Query(value = " INSERT INTO `employee` (`birthday`, `email`, `id_card`, `name`, " +
            " `phone_number`, `salary`, `division_id`, `education_degree_id`, `position_id`, `username`) " +
            " VALUES (:#{#employee.birthday}, :#{#employee.email}, :#{#employee.idCard}, :#{#employee.name}, " +
            " :#{#employee.phoneNumber}, :#{#employee.salary}, :#{#employee.division.id}, :#{#employee.educationDegree.id}, " +
            " :#{#employee.position}, :#{#employee.email}); ", nativeQuery = true)
    void saveEmployee(@Param("employee") Employee employee);
}
