package com.phuong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichController {

    @GetMapping("/save")
    public String save(
            @RequestParam String[] condiment,
            Model model
    ) {
        model.addAttribute("result", Arrays.toString(condiment));
        return "result";
    }
}
