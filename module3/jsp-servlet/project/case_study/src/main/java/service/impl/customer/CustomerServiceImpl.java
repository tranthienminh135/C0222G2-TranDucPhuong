package service.impl.customer;

import model.customer.Customer;
import model.customer.CustomerType;
import repository.customer.ICustomerRepository;
import repository.impl.customer.CustomerRepositoryImpl;
import service.customer.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> getAllCustomerIsActive() {
        return customerRepository.getAllCustomerIsActive();
    }

    @Override
    public List<CustomerType> getAllCustomerType() {
        return customerRepository.getAllCustomerType();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        customerRepository.deleteCustomer(customerId);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }

    @Override
    public Customer getCustomerForEdit(int customerId) {
        return customerRepository.getCustomerForEdit(customerId);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    @Override
    public List<Customer> searchCustomerByName(String customerSearchValue) {
        return customerRepository.searchCustomerByName(customerSearchValue);
    }
}
