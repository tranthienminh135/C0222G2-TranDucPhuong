package com.phuong.controller.employee;

import com.phuong.model.employee.Employee;
import com.phuong.model.employee.dto.EmployeeDto;
import com.phuong.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<Page<Employee>> getAllEmployee(@PageableDefault(5) Pageable pageable, Optional<String> searchValue) {
        String searchParam = searchValue.orElse("");
        Page<Employee> employees = this.employeeService.findAll(pageable, searchParam);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/employee/create")
    public ResponseEntity<Void> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        this.employeeService.save(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/employee/delete/{idDelete}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String idDelete) {
        this.employeeService.delete(idDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/employee/edit/{idEdit}")
    public ResponseEntity<Employee> goEditEmployee(@PathVariable String idEdit) {
        return new ResponseEntity<>(this.employeeService.getById(idEdit), HttpStatus.OK);
    }

    @PutMapping("/employee/edit")
    public ResponseEntity<Void> saveChangesEdit(@RequestBody Employee employee) {
        this.employeeService.save(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
