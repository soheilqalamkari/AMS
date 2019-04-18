package com.asm.managment.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUCT_BASE_DETAILS",catalog = "ASM",schema = "system")
public class ProductBaseDetail implements Serializable {

    //private Long baseDetailId;
    private Long serialNo;
    private String modelNo;
    private String partNo;
    @JsonIgnore
    private Product product;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "PRODUCT_BASE_DETAIL_ID")
//    public Long getBaseDetailId() {
//        return baseDetailId;
//    }
//
//    public void setBaseDetailId(Long baseDetailId) {
//        this.baseDetailId = baseDetailId;
//    }


    public ProductBaseDetail() {
        super();
    }

    public ProductBaseDetail(Long serialNo, String modelNo, String partNo, Product product) {
        this.serialNo = serialNo;
        this.modelNo = modelNo;
        this.partNo = partNo;
        this.product = product;
    }

    @Id
    @Column(name = "PRODUCT_SERIAL_NO")
    public Long getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }

    @Id
    @Column(name = "PRODUCT_MODEL_NO",length = 225)
    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    @Column(name = "PRODUCT_PART_NO",length = 225)
    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
