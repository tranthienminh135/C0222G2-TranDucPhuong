package service.impl;

import model.Customer;
import model.CustomerType;
import repository.ICustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.ICustomerService;

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
}
