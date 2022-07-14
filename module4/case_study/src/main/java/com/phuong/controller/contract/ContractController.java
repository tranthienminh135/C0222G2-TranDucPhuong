package com.phuong.controller.contract;

import com.phuong.model.contract.AttachFacility;
import com.phuong.model.customer.Customer;
import com.phuong.model.employee.Employee;
import com.phuong.model.facility.Facility;
import com.phuong.service.attach_facility.IAttachFacilityService;
import com.phuong.service.customer.ICustomerService;
import com.phuong.service.employee.IEmployeeService;
import com.phuong.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class ContractController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private IEmployeeService employeeService;

    @ModelAttribute("customerList")
    public List<Customer> getAllCustomer() {
        return this.customerService.findAll();
    }

    @ModelAttribute("facilityList")
    public List<Facility> getAllFacility() {
        return this.facilityService.findAll();
    }

    @ModelAttribute("attachFacilityList")
    public List<AttachFacility> getAllAttachFacility() {
        return this.attachFacilityService.findAll();
    }

    @ModelAttribute("employeeList")
    public List<Employee> getAllEmployee () {
        return this.employeeService.findAll();
    }

    @GetMapping("/contract")
    public String goContract() {
        return "contract/list";
    }
}
