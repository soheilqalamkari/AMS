package com.asm.managment.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "GUARANTEES",catalog = "ASM",schema = "test")
public class Guarantee implements Serializable {


    private Long guaranteeId;
    private String name;
    private String details;
    private Date during;
    @JsonIgnore
    private Product product;
    private Long productId;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GUARANTEE_ID")
    public Long getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(Long guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    @Column(name = "GUARANTEE_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "GUARANTEE_DETAIL",length = 4000)
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Column(name = "GUARANTEE_DURING")
    public Date getDuring() {
        return during;
    }

    public void setDuring(Date during) {
        this.during = during;
    }

    @ManyToOne
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Transient
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
