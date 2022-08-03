package com.phuong.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Consignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    private Integer quantity;

    private Date dateIn;

    private Date dateOut;
    
    private Date dateEnd;

    private String imgUrl;

    public Consignment() {
    }

    public Consignment(Integer id, String code, Product product, Integer quantity, Date dateIn, Date dateOut, Date dateEnd, String imgUrl) {
        this.id = id;
        this.code = code;
        this.product = product;
        this.quantity = quantity;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.dateEnd = dateEnd;
        this.imgUrl = imgUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
