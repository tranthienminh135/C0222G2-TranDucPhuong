package com.phuong.service.employee.impl;

import com.phuong.model.employee.Employee;
import com.phuong.model.employee.User;
import com.phuong.repository.employee.IEmployeeRepository;
import com.phuong.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable, String searchParam) {
        return this.employeeRepository.findAll(pageable, "%" + searchParam + "%");
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.saveEmployee(employee);
    }

    @Override
    public void delete(String idDelete) {
        this.employeeRepository.delete(this.employeeRepository.getById(Integer.valueOf(idDelete)));
    }

    @Override
    public Employee getById(String idEdit) {
        return this.employeeRepository.findById(Integer.valueOf(idEdit)).orElse(null);
    }
}
