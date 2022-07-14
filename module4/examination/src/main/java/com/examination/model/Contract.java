package com.examination.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Contract {

    @Id
    private String contractCode;

    private String name;

    private String idCard;

    private Date costDate;

    private String costTime;

    @Transient
    private Double totalMoney;

    @OneToOne
    @JoinColumn(name = "room_code", referencedColumnName = "id")
    private Room room;

    public Contract() {
    }

    public Contract(String contractCode, String name, String idCard, Date costDate, String costTime, Double totalMoney, Room room) {
        this.contractCode = contractCode;
        this.name = name;
        this.idCard = idCard;
        this.costDate = costDate;
        this.costTime = costTime;
        this.totalMoney = totalMoney;
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

    public void setCostDate(Date startDate) {
        this.costDate = startDate;
    }

    public String getCostTime() {
        return costTime;
    }

    public void setCostTime(String time) {
        this.costTime = time;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
