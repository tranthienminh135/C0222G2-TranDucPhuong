package com.examination.model;

import javax.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "room_code")
    private String roomCode;

    private Double area;

    private Double price;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean status;

    @OneToOne(mappedBy = "room")
    private Contract contract;

    public Room() {
    }

    public Room(Integer id, String roomCode, Double area, Double price, Boolean status, Contract contract) {
        this.id = id;
        this.roomCode = roomCode;
        this.area = area;
        this.price = price;
        this.status = status;
        this.contract = contract;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
