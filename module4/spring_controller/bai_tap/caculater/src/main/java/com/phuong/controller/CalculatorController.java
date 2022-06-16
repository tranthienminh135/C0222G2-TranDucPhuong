package com.phuong.controller;

import com.phuong.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("/calculator")
    public String showFormCaculate() {
        return "calculator";
    }

    @PostMapping("/calculator")
    public String caculate(
            @RequestParam double firstNumber,
            @RequestParam double secondNumber,
            @RequestParam String operator,
            Model model
    ) {
        if (operator.equals("/") && secondNumber == 0) {
            model.addAttribute("alert", "Số " + firstNumber + " mà chia được cho 0 à?");
        } else {
            model.addAttribute("result", calculatorService.calculate(firstNumber,secondNumber,operator));
        }
        return "calculator";
    }
}
