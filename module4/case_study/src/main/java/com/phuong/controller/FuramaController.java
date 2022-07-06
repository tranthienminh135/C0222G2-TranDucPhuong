package com.phuong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FuramaController {

    @GetMapping(value = {"/home", "/", "furama"})
    public String goHome(){
        return "homePage";
    }
}
