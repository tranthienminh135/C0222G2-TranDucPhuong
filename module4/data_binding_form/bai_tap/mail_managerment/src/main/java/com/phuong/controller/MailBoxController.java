package com.phuong.controller;

import com.phuong.model.MailBox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailBoxController {

    @GetMapping("/mail")
    public String showFormMailBox(Model model) {
        model.addAttribute("mailBox", new MailBox());
        return "mail-form";
    }

    @PostMapping("/mail")
    public String saveMailBox(@ModelAttribute MailBox mailBox, Model model) {
        model.addAttribute("mailBoxResult", mailBox);
        return "mail-form";
    }
}
