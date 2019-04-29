package com.asm.managment.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "SUPPLIERS",catalog = "ASM",schema = "test")
public class Supplier implements Serializable {

    private Long supplierId;
    private String name;
    private Long phone;
   // private List<Factor> FactorList;
//    private List<Product> productList;

    public Supplier() {
        super();
    }

    public Supplier(Long supplierId, String name, Long phone) {
        this.supplierId = supplierId;
        this.name = name;
        this.phone = phone;
       // FactorList = factorList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUPPLIER_ID")
    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    @Column(name = "SUPPLIER_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SUPPLIER_PHONE")
    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier", fetch = FetchType.LAZY)
//    public List<Factor> getFactorList() {
//        return FactorList;
//    }
//
//    public void setFactorList(List<Factor> factorList) {
//        FactorList = factorList;
//    }


//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "supplier",fetch = FetchType.LAZY)
//    public List<Product> getProductList() {
//        return productList;
//    }
//
//    public void setProductList(List<Product> productList) {
//        this.productList = productList;
//    }



}
