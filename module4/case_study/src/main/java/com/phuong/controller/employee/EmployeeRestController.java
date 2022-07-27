package com.phuong.controller.employee;

import com.phuong.model.employee.*;
import com.phuong.model.employee.dto.EmployeeDto;
import com.phuong.service.division.IDivisionService;
import com.phuong.service.education_degree.IEducationDegreeService;
import com.phuong.service.employee.IEmployeeService;
import com.phuong.service.position.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.EscapedErrors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @GetMapping("/employee")
    public ResponseEntity<Page<Employee>> getAllEmployee(@PageableDefault(7) Pageable pageable, Optional<String> searchValue) {
        String searchParam = searchValue.orElse("");
        Page<Employee> employees = this.employeeService.findAll(pageable, searchParam);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employee/find-by-id/{id}")
    public ResponseEntity<Employee> findById(@PathVariable String id) {
        Employee employee = this.employeeService.getById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/employee/list")
    public ResponseEntity<List<Employee>> getAllEmployeeList() {
        List<Employee> employees = this.employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping(value = "/employee/create")
    public ResponseEntity<List<ObjectError>> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto, BindingResult bindingResult) {
        EmployeeDto ed = new EmployeeDto();
        ed.setEmployeeList(this.employeeService.findAll());
        List<String> idCardList = new ArrayList<>();
        for (Employee employee: this.employeeService.findAll()) {
            idCardList.add(employee.getIdCard());
        }
        ed.setIdCardList(idCardList);
        ed.validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            this.employeeService.save(employee);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
    @PatchMapping(value = "/employee/edit")
    public ResponseEntity<List<ObjectError>> saveChangesEdit(@Valid @RequestBody EmployeeDto employeeDto , BindingResult bindingResult) {
        EmployeeDto ed = new EmployeeDto();
        if (!this.employeeService.getById(String.valueOf(employeeDto.getId())).getEmail().equals(employeeDto.getEmail())) {
            ed.setEmployeeList(this.employeeService.findAll());
        } else {
            ed.setEmployeeList(new ArrayList<>());
        }
        List<String> idCardList = new ArrayList<>();
        if (!this.employeeService.getById(String.valueOf(employeeDto.getId())).getIdCard().equals(employeeDto.getIdCard())) {
            for (Employee employee: this.employeeService.findAll()) {
                idCardList.add(employee.getIdCard());
                ed.setIdCardList(idCardList);
            }
        } else {
            ed.setIdCardList(new ArrayList<>());
        }
        ed.validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            this.employeeService.saveEmployee(employee);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
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

    @GetMapping("/division")
    public ResponseEntity<List<Division>> getAllDivision() {
        List<Division> divisionList = this.divisionService.findAll();
        return new ResponseEntity<>(divisionList, HttpStatus.OK);
    }

    @GetMapping("/position")
    public ResponseEntity<List<Position>> getAllPosition() {
        List<Position> positionList = this.positionService.findAll();
        return new ResponseEntity<>(positionList, HttpStatus.OK);
    }

    @GetMapping("/education-degree")
    public ResponseEntity<List<EducationDegree>> getAllEducationDegree() {
        List<EducationDegree> educationDegreeList = this.educationDegreeService.findAll();
        return new ResponseEntity<>(educationDegreeList, HttpStatus.OK);
    }
}
