package com.asm.managment.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT_BASE_DETAILS",catalog = "ASM",schema = "test")
public class ProductBaseDetail implements Serializable {

    private Long serialNo;
    private String modelNo;
    private String partNo;
    @JsonIgnore
    private Product product;
    private Long productId;


    public ProductBaseDetail() {
        super();
    }

    public ProductBaseDetail(Long serialNo, String modelNo, String partNo, Product product, Long productId) {
        this.serialNo = serialNo;
        this.modelNo = modelNo;
        this.partNo = partNo;
        this.product = product;
        this.productId = productId;
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

    //    @Id
//    @Column(name = "PRODUCT_SERIAL_NO")
//    public Long getSerialNo() {
//        return serialNo;
//    }
//
//    public void setSerialNo(Long serialNo) {
//        this.serialNo = serialNo;
//    }
//
//    @Id
//    @Column(name = "PRODUCT_MODEL_NO",length = 225)
//    public String getModelNo() {
//        return modelNo;
//    }
//
//    public void setModelNo(String modelNo) {
//        this.modelNo = modelNo;
//    }

    @Column(name = "PRODUCT_PART_NO",length = 225)
    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBaseDetail that = (ProductBaseDetail) o;
        return Objects.equals(serialNo, that.serialNo) &&
                Objects.equals(modelNo, that.modelNo) &&
                Objects.equals(partNo, that.partNo) &&
                Objects.equals(product, that.product) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(serialNo, modelNo, partNo, product, productId);
    }
}
