package com.phuong.service.customer.impl;

import com.phuong.model.contract.AttachFacility;
import com.phuong.model.contract.Contract;
import com.phuong.model.contract.ContractDetail;
import com.phuong.model.customer.Customer;
import com.phuong.model.customer.CustomerAndAttachFacilityDto;
import com.phuong.repository.customer.ICustomerRepository;
import com.phuong.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable, String searchParam) {
        return this.customerRepository.getAllCustomer(pageable, "%" + searchParam + "%");
    }

    @Override
    public void delete(String idEdit) {
        this.customerRepository.delete(this.customerRepository.getById(Integer.valueOf(idEdit)));
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public Customer getById(String idEdit) {
        return this.customerRepository.getById(Integer.valueOf(idEdit));
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Page<Customer> findCustomerUsingFacility(Pageable pageable) {
        return this.customerRepository.findCustomerUsingFacility(pageable);
    }

    @Override
    public Page<CustomerAndAttachFacilityDto> getCustomerAndAF(Pageable pageable) {
        Page<Customer> customerPage = this.customerRepository.findCustomerUsingFacility(pageable);
        List<CustomerAndAttachFacilityDto> customerAndAttachFacilityDtoList = new ArrayList<>();
        Page<CustomerAndAttachFacilityDto> customerDtoPage = new PageImpl<>(customerAndAttachFacilityDtoList);
        for (Customer customer: customerPage.getContent()) {
            CustomerAndAttachFacilityDto customerAndAttachFacilityDto = new CustomerAndAttachFacilityDto(customer);
            List<AttachFacility> attachFacilityList = new ArrayList<>();
            for (Contract contract: customer.getContractList()) {
                for (ContractDetail contractDetail: contract.getContractDetailList()) {
                    attachFacilityList.add(contractDetail.getAttachFacility());
                }
                break;
            }
            customerAndAttachFacilityDto.setAttachFacilityList(attachFacilityList);
            customerAndAttachFacilityDtoList.add(customerAndAttachFacilityDto);
        }
        customerDtoPage = new PageImpl<>(customerAndAttachFacilityDtoList);

        return customerDtoPage;
    }
}
