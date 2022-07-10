package com.phuong.service.employee;

import com.phuong.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable, String searchParam);

    void save(Employee employee);

    void delete(String idDelete);

    Employee getById(String idEdit);

    List<Employee> findAll();
}
