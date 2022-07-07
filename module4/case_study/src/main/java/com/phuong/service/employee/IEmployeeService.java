package com.phuong.service.employee;

import com.phuong.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable, String searchParam);

    Employee save(Employee employee);

    void delete(String idDelete);

    Employee getById(String idEdit);
}
