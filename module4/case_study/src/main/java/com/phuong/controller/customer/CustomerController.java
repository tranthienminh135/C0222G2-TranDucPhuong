package com.phuong.controller.customer;

import com.phuong.model.customer.Customer;
import com.phuong.model.customer.CustomerType;
import com.phuong.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerTypeService customerTypeService;

    @ModelAttribute("customerTypeList")
    public List<CustomerType> getAllCustomerType() {
        return this.customerTypeService.findAll();
    }

    @GetMapping("/customer")
    public String goCustomer() {
        return "customer/list";
    }

    @GetMapping("/customer/create")
    public String goCreateCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @GetMapping("/customer/edit")
    public String goEditCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/edit";
    }

}
