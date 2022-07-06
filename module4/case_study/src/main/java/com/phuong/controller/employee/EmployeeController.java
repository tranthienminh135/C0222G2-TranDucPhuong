package com.phuong.controller.employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping("/employee")
    public String goEmployee() {
        return "employee/list";
    }
}
