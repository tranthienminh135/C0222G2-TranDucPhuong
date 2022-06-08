package service.customer;

import dto.CustomerUsingServiceDTO;
import model.customer.Customer;
import model.customer.CustomerType;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> getAllCustomerIsActive();

    List<CustomerType> getAllCustomerType();

    void saveCustomer(Customer customer);

    void deleteCustomer(int customerId);

    List<Customer> getAllCustomer();

    Customer getCustomerForEdit(int customerId);

    Map<String, String> updateCustomer(Customer customer);

    List<Customer> searchCustomerByName(String customerSearchValue);

    List<CustomerUsingServiceDTO> getAllCustomerUsingServiceDTO();
}
