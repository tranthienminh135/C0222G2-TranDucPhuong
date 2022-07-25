package com.phuong.controller.customer;

import com.phuong.model.customer.Customer;
import com.phuong.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/rest")
@CrossOrigin
public class CustomerRestController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<Page<Customer>> getAllCustomer(@PageableDefault(50) Pageable pageable,
            Optional<String> searchValue) {
        String searchParam = searchValue.orElse("");
        Page<Customer> customerPage = this.customerService.findAll(pageable, searchParam);
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }
    @DeleteMapping("customer/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        this.customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
