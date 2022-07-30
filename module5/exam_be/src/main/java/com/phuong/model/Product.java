package com.phuong.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String madeIn;

    private Integer price;

    private String unit;

    @OneToMany(mappedBy = "product")
    private List<Consignment> consignmentList;

    public Product() {
    }

    public Product(Long id, String name, String madeIn, Integer price, String unit, List<Consignment> consignmentList) {
        this.id = id;
        this.name = name;
        this.madeIn = madeIn;
        this.price = price;
        this.unit = unit;
        this.consignmentList = consignmentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<Consignment> getConsignmentList() {
        return consignmentList;
    }

    public void setConsignmentList(List<Consignment> consignmentList) {
        this.consignmentList = consignmentList;
    }
}
