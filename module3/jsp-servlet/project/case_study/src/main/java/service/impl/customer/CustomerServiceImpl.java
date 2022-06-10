package service.impl.customer;

import common.check_regex.CheckRegex;
import dto.CustomerUsingServiceDTO;
import model.customer.Customer;
import model.customer.CustomerType;
import repository.customer.ICustomerRepository;
import repository.impl.customer.CustomerRepositoryImpl;
import service.customer.ICustomerService;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepositoryImpl();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public List<Customer> getAllCustomerIsActive() {
        return customerRepository.getAllCustomerIsActive();
    }

    @Override
    public List<CustomerType> getAllCustomerType() {
        return customerRepository.getAllCustomerType();
    }

    @Override
    public Map<String, String> saveCustomer(Customer customer) {
        Map<String, String> errMap = new HashMap<>();

        List<CustomerType> customerTypes = customerRepository.getAllCustomerType();
        boolean flag = false;
        for (CustomerType customerType : customerTypes) {
            if (customer.getCustomerTypeId() == customerType.getCustomerTypeId()) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            errMap.put("errCustomerTypeId", "Ôi bạn ơi! đừng f12!");
        }
        if (customer.getCustomerName() == null || customer.getCustomerName().equals("")) {
            errMap.put("errCustomerName", "Tên không được để trống nha bạn!");
        }
        if (customer.getCustomerBirthday() == null || customer.getCustomerBirthday().equals("")) {
            errMap.put("errCustomerBirthday", "Nhập dữ liệu đi bạn!");
        } else {
            try {
                customer.setCustomerBirthday(simpleDateFormat.format(simpleDateFormat.parse(customer.getCustomerBirthday())));
            } catch (ParseException e) {
                errMap.put("errCustomerBirthday", "Ôi bạn ơi! đừng f12!");
            }
        }
        try {
            if ((simpleDateFormat.parse(customer.getCustomerBirthday()).getTime()) > (new Date()).getTime()) {
                errMap.put("errCustomerBirthday", "Ôi bạn ơi bạn sinh ra ở tương lai à?");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (customer.getCustomerGender() < 0 || customer.getCustomerGender() > 2) {
            errMap.put("errCustomerGender", "Ôi bạn ơi! đừng f12!");
        }
        if (customer.getCustomerIdCard() == null || customer.getCustomerIdCard().equals("")) {
            errMap.put("errCustomerIdCard", "Id Card không để trống bạn ơi!");
        } else if (!CheckRegex.checkRegexIDCard(customer.getCustomerIdCard())) {
            errMap.put("errCustomerIdCard", "Id Card phải có 9 hoặc 12 số bạn à!");
        }
        if (customer.getCustomerPhone() == null || customer.getCustomerPhone().equals("")) {
            errMap.put("errCustomerPhone", "Số điện thoại không được để trống bạn à!");
        } else if (!CheckRegex.checkRegexPhone(customer.getCustomerPhone())) {
            errMap.put("errCustomerPhone", "Số điện thoại phải có 9 số và bắt đầu bằng 09-XXXXXXX hoặc 849-XXXXXXX nhé bạn!");
        }
        if (customer.getCustomerEmail() == null || customer.getCustomerEmail().equals("")) {
            errMap.put("errCustomerEmail", "Email không được để trống nha bạn!");
        } else if (!CheckRegex.checkRegexEmail(customer.getCustomerEmail())) {
            errMap.put("errCustomerEmail", "Email không đúng định dạng (VD: lethitai69@gmail.com) nè bạn!");
        }
        if (customer.getCustomerAddress() == null || customer.getCustomerAddress().equals("")) {
            errMap.put("errCustomerAddress", "Địa chỉ không được để trống nhé bạn!");
        }

        if (errMap.isEmpty()) {
            customerRepository.saveCustomer(customer);
        }
        return errMap;
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
    public Map<String, String> updateCustomer(Customer customer) {
        Map<String, String> errMap = new HashMap<>();

        List<CustomerType> customerTypes = customerRepository.getAllCustomerType();
        boolean flag = false;
        for (CustomerType customerType : customerTypes) {
            if (customer.getCustomerTypeId() == customerType.getCustomerTypeId()) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            errMap.put("errCustomerTypeId", "Ôi bạn ơi! đừng f12!");
        }
        if (customer.getCustomerName() == null || customer.getCustomerName().equals("")) {
            errMap.put("errCustomerName", "Tên không được để trống nha bạn!");
        }
        if (customer.getCustomerBirthday() == null || customer.getCustomerBirthday().equals("")) {
            errMap.put("errCustomerBirthday", "Nhập dữ liệu đi bạn!");
        } else {
            try {
                customer.setCustomerBirthday(simpleDateFormat.format(simpleDateFormat.parse(customer.getCustomerBirthday())));
            } catch (ParseException e) {
                errMap.put("errCustomerBirthday", "Ôi bạn ơi! đừng f12!");
            }
        }
        try {
            if ((simpleDateFormat.parse(customer.getCustomerBirthday()).getTime()) > (new Date()).getTime()) {
                errMap.put("errCustomerBirthday", "Ôi bạn ơi bạn sinh ra ở tương lai à?");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (customer.getCustomerGender() < 0 || customer.getCustomerGender() > 2) {
            errMap.put("errCustomerGender", "Ôi bạn ơi! đừng f12!");
        }
        if (customer.getCustomerIdCard() == null || customer.getCustomerIdCard().equals("")) {
            errMap.put("errCustomerIdCard", "Id Card không để trống bạn ơi!");
        }
        if (customer.getCustomerPhone() == null || customer.getCustomerPhone().equals("")) {
            errMap.put("errCustomerPhone", "Số điện thoại không được để trống bạn à!");
        } else if (!CheckRegex.checkRegexPhone(customer.getCustomerPhone())) {
            errMap.put("errCustomerPhone", "Số điện thoại phải có 9 số và bắt đầu bằng 09-XXXXXXX hoặc 849-XXXXXXX nhé bạn!");
        }
        if (customer.getCustomerEmail() == null || customer.getCustomerEmail().equals("")) {
            errMap.put("errCustomerEmail", "Email không được để trống nha bạn!");
        } else if (!CheckRegex.checkRegexEmail(customer.getCustomerEmail())) {
            errMap.put("errCustomerEmail", "Email không đúng định dạng (VD: lethitai69@gmail.com) nè bạn!");
        }
        if (customer.getCustomerAddress() == null || customer.getCustomerAddress().equals("")) {
            errMap.put("errCustomerAddress", "Địa chỉ không được để trống nhé bạn!");
        }
        if (customer.getStatus() < 0 || customer.getStatus() > 1) {
            errMap.put("errStatus", "Ôi bạn ơi! đừng f12!");
        }

        if (errMap.isEmpty()) {
            customerRepository.updateCustomer(customer);
        }
        return errMap;
    }

    @Override
    public List<Customer> searchCustomerByName(String customerNameSearchValue, String customerAddressSearchValue) {
        return customerRepository.searchCustomerByName(customerNameSearchValue, customerAddressSearchValue);
    }

    @Override
    public List<CustomerUsingServiceDTO> getAllCustomerUsingServiceDTO() {
        return customerRepository.getAllCustomerUsingServiceDTO();
    }
}
