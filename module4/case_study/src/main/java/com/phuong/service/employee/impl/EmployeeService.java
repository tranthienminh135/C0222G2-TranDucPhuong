package com.phuong.service.employee.impl;

import com.phuong.model.employee.Employee;
import com.phuong.repository.employee.IEmployeeRepository;
import com.phuong.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
        employee.setDeleted(false);
        this.employeeRepository.save(employee);
    }

    @Override
    public void delete(String idDelete) {
        Employee employee = this.employeeRepository.getById(Integer.valueOf(idDelete));
        employee.setDeleted(true);
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getById(String idEdit) {
        return this.employeeRepository.findById(idEdit);
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAllEmployee();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employee.setDeleted(false);
        this.employeeRepository.save(employee);
    }
}
