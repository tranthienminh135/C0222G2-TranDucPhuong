package repository.customer;

import dto.CustomerUsingServiceDTO;
import model.customer.Customer;
import model.customer.CustomerType;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAllCustomerIsActive();

    List<CustomerType> getAllCustomerType();

    void saveCustomer(Customer customer);

    void deleteCustomer(int customerId);

    List<Customer> getAllCustomer();

    Customer getCustomerForEdit(int customerId);

    void updateCustomer(Customer customer);

    List<Customer> searchCustomerByName(String customerSearchValue);

    List<CustomerUsingServiceDTO> getAllCustomerUsingServiceDTO();
}
