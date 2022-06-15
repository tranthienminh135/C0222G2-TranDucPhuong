package com.phuong.controller;

import com.phuong.model.Customer;
import com.phuong.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/customer")
    public String greeting(Model model) {
        List<Customer> customerList = customerService.getAllCustomer();
        model.addAttribute("listCustomer", customerList);
        return "customer-home";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam String idDelete) {
        customerService.deleteCustomer(idDelete);
        return "redirect:/customer";
    }

    @GetMapping("/add")
    public String showFormAddNewCustomer() {
        return "customer-form-create";
    }

    @PostMapping("/add")
    public String addNewCustomer(
            @RequestParam String id,
            @RequestParam String name,
            @RequestParam Integer age,
            @RequestParam Double point
    ) {
        Customer customer = new Customer(id, name, age, point);
        customerService.addNewCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping("/edit")
    public String showFormEdit(@RequestParam String idEdit, Model model) {
        Customer customer = customerService.getCustomerForEdit(idEdit);
        model.addAttribute("customer", customer);
        return "customer-form-edit";
    }

    @PostMapping("/edit")
    public String editCustomer(
            @RequestParam String id,
            @RequestParam String name,
            @RequestParam Integer age,
            @RequestParam Double point
    ) {
        Customer customer = new Customer(id, name, age, point);
        customerService.editCustomer(customer);
        return "redirect:/customer";
    }
}