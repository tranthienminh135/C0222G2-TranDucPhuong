package com.phuong.controller;

import com.phuong.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class showInformation {
    @GetMapping("/{id}")
    public ModelAndView abc(@PathVariable Long id) {
        try {
            ModelAndView modelAndView = new ModelAndView("/customers/info");
            Optional<Customer> customerOptional = customerService.findOne(id);
            modelAndView.addObject("customer", customerOptional.get());
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:/customers");
        }
    }
}
