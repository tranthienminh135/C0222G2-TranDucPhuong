package com.phuong.model.dto;

import com.phuong.model.Employee;
import com.phuong.model.OrderService;
import com.phuong.model.Product;
import com.phuong.model.ProductType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductDto implements Validator {

    private Integer id;

    private String code;

    private String name;

    private Double price;

    private Boolean status;

    private Date dateIn;

    private String origin;

    private Boolean gas;

    private Boolean sweet;

    private String author;

    private String category;

    private Date publicDate;

    private ProductType productType;

    private List<OrderService> orderServices;

    private Employee employee;

    private List<Product> products;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        for (Product product : this.products) {
            if (product.getCode().equals(productDto.code)) {
                errors.rejectValue("code", "CodeExists", "CodeExists");
            }
        }
    }
}
