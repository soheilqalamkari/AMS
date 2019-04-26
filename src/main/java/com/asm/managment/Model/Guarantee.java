package com.asm.managment.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "GUARANTEES",catalog = "ASM",schema = "test")
public class Guarantee implements Serializable {


    private Long guaranteeId;
    private String name;
    private String details;
    private Integer during;
    @JsonIgnore
    private Product product;
    private Long productId;


    public Guarantee() {
        super();
    }

    public Guarantee(Long guaranteeId, String name, String details, Integer during, Product product, Long productId) {
        this.guaranteeId = guaranteeId;
        this.name = name;
        this.details = details;
        this.during = during;
        this.product = product;
        this.productId = productId;
    }

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
    public Integer getDuring() {
        return during;
    }

    public void setDuring(Integer during) {
        this.during = during;
    }

    @ManyToOne(fetch = FetchType.LAZY)
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
