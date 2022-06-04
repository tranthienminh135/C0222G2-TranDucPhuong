package repository;

import model.Customer;
import model.CustomerType;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAllCustomerIsActive();

    List<CustomerType> getAllCustomerType();

    void saveCustomer(Customer customer);

    void deleteCustomer(int customerId);

    List<Customer> getAllCustomer();
}
