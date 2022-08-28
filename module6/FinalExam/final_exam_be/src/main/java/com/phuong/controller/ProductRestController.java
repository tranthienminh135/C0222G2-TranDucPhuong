package com.phuong.controller;

import com.phuong.model.Product;
import com.phuong.model.ProductType;
import com.phuong.model.dto.ProductDto;
import com.phuong.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class ProductRestController {

    @Autowired
    private IProductService productService;

    @GetMapping("/product/list")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> productList = this.productService.findAllProduct();
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/product-type/list")
    public ResponseEntity<List<ProductType>> getAllProductType() {
        List<ProductType> productTypeList = this.productService.findAllProductType();
        if (productTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productTypeList, HttpStatus.OK);
    }

    @PostMapping("/product/create")
    public ResponseEntity<FieldError> createProduct(@Valid @RequestBody ProductDto productDto, BindingResult bindingResult) {
        ProductDto pd = new ProductDto();
        pd.setProducts(this.productService.findAllProduct());
        pd.validate(productDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        this.productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        this.productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
