package com.examination.controller;

import com.examination.dto.ContractDto;
import com.examination.model.Contract;
import com.examination.model.Room;
import com.examination.service.IContractService;
import com.examination.service.IRoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IRoomService roomService;

    @ModelAttribute("roomList")
    private List<Room> getAllRoom() {
        return this.roomService.getAllRoom();
    }

    @GetMapping("/contract")
    public String goContractList(Model model) {
        List<Contract> contractList = this.contractService.findAll();
        model.addAttribute("contractList", contractList);
        return "list";
    }

    @GetMapping("/contract/create")
    public String goCreateContract(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        return "create";
    }

    @PostMapping("/contract/create")
    public String saveContract(@Valid @ModelAttribute("contractDto") ContractDto contractDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        this.contractService.save(contract);
        this.roomService.setStatus(contract.getRoom().getRoomCode());
        redirectAttributes.addFlashAttribute("message", "Add new success");
        return "redirect:/contract";
    }

    @GetMapping("/contract/delete/{contractCode}")
    public String deleteContract(@PathVariable String contractCode, RedirectAttributes redirectAttributes) {
        Contract contract = this.contractService.findById(contractCode);
        this.roomService.updateStatus(contract.getRoom().getId());
        this.contractService.delete(contractCode);
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return "redirect:/contract";
    }
}
