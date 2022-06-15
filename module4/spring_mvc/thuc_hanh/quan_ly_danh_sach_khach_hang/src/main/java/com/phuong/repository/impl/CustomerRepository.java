package com.phuong.repository.impl;

import com.phuong.model.Customer;
import org.springframework.stereotype.Repository;
import com.phuong.repository.ICustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer("CU-1234","Le Thi Tai", 16, 5d));
        customerList.add(new Customer("CU-2345","Le Thi Hau", 17, 6d));
        customerList.add(new Customer("CU-3456","Le Thi Tri", 18, 7d));
        customerList.add(new Customer("CU-4567","Le Thi Hoan", 19, 8d));
        customerList.add(new Customer("CU-5678","Le Thi Binh", 20, 9d));
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerList;
    }

    @Override
    public void deleteCustomer(String idDelete) {
        customerList.removeIf(customer -> customer.getCustomerId().equals(idDelete));
    }

    @Override
    public void addNewCustomer(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public Customer getCustomerForEdit(String idEdit) {
        for (Customer customer: customerList) {
            if (customer.getCustomerId().equals(idEdit)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void editCustomer(Customer customer) {
        for (Customer c: customerList) {
            if (c.getCustomerId().equals(customer.getCustomerId())) {
                c.setCustomerName(customer.getCustomerName());
                c.setCustomerAge(customer.getCustomerAge());
                c.setCustomerPoint(customer.getCustomerPoint());
                break;
            }
        }
    }
}
