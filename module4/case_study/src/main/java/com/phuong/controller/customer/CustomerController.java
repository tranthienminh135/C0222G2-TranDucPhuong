package com.phuong.controller.customer;

import com.phuong.model.customer.Customer;
import com.phuong.model.customer.CustomerDto;
import com.phuong.model.customer.CustomerType;
import com.phuong.service.customer.ICustomerService;
import com.phuong.service.customer_type.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerTypeService customerTypeService;

    @Autowired
    private ICustomerService customerService;

    @ModelAttribute("customerTypeList")
    public List<CustomerType> getAllCustomerType() {
        return this.customerTypeService.findAll();
    }

    @GetMapping("/customer")
    public String goCustomer(@PageableDefault(5) Pageable pageable, Optional<String> searchValue, Model model) {
        String searchParam = searchValue.orElse("");
        Page<Customer> customers = this.customerService.findAll(pageable, searchParam);
        model.addAttribute("customers", customers);
        model.addAttribute("searchParam", searchParam);
        return "customer/list";
    }

    @GetMapping("/customer/create")
    public String goCreateCustomer(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/create";
    }

    @PostMapping("/customer/create")
    public String saveCustomer(@Valid @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/customer/edit/{idEdit}")
    public String goEditCustomer(Model model, @PathVariable String idEdit) {
        Customer customer = this.customerService.getById(idEdit);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto", customerDto);
        return "customer/edit";
    }

    @PostMapping("/customer/edit")
    public String saveChanges(@Valid @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        this.customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/customer/delete/{idEdit}")
    public String deleteCustomer(@PathVariable String idEdit) {
        this.customerService.delete(idEdit);
        return "redirect:/customer";
    }

}
