package com.phuong.controller.contract;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContractController {

    @GetMapping("/contract")
    public String goContract() {
        return "contract/list";
    }
}
