package com.phuong.controller;

import com.phuong.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class LoginController {

    @Autowired
    private ILoginService loginService;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private Matcher matcher;

    @GetMapping("/login")
    public String showFormLogin() {
        return "login-form";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password,
            Model model
    ) {
        if (!validate(email)) {
            model.addAttribute("email", email);
            model.addAttribute("password", password);
            model.addAttribute("alert", "Email nhập thế à?");
        } else {
            boolean check = loginService.checkLogin(email, password);
            if (check) {
                model.addAttribute("username", email);
                return "welcome";
            } else {
                model.addAttribute("email", email);
                model.addAttribute("password", password);
                model.addAttribute("alert", "Nhập sai nhập lại di");
            }
        }
        return "login-form";
    }

    private boolean validate(String regex) {
        return regex.matches(EMAIL_REGEX);
    }
}
