package com.examination.dto;

import com.examination.model.Contract;
import com.examination.model.Room;
import com.examination.service.IContractService;
import com.examination.service.impl.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.List;

public class ContractDto {

    @Pattern(regexp = "^(HD-)[0-9]{4}$", message = "Contract Code invalid. (HD-XXXX)")
    private String contractCode;

    @NotBlank
    private String name;

    @NotBlank
    private String idCard;

    private Date costDate;

    private String costTime;

    private Room room;

    public ContractDto() {
    }

    public ContractDto(String contractCode, String name, String idCard, Date costDate, String costTime, Room room) {
        this.contractCode = contractCode;
        this.name = name;
        this.idCard = idCard;
        this.costDate = costDate;
        this.costTime = costTime;
        this.room = room;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getCostDate() {
        return costDate;
    }

    public void setCostDate(Date costDate) {
        this.costDate = costDate;
    }

    public String getCostTime() {
        return costTime;
    }

    public void setCostTime(String costTime) {
        this.costTime = costTime;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
