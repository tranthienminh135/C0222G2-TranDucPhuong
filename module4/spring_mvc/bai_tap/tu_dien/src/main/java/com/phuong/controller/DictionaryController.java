package com.phuong.controller;

import com.phuong.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("/translation")
    public String showTranslationForm() {
        return "translation";
    }

    @PostMapping("/translation")
    public String translation(
            @RequestParam String english,
            Model model
    ) {
        String value = dictionaryService.translation(english);
        if (value == null) {
            model.addAttribute("alert", "Nhập chữ khác đi chữ này từ điển chưa có!");
        } else {
            model.addAttribute("vietnamese", value);
        }
        model.addAttribute("english", english);
        return "translation";
    }
}
