package com.phuong.model.customer;

import javax.persistence.*;
import java.util.List;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "customerType")
    private List<Customer> customers;

    public CustomerType() {
    }

    public CustomerType(Integer id, String name, List<Customer> customers) {
        this.id = id;
        this.name = name;
        this.customers = customers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
