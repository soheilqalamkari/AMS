package com.asm.managment.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;


/**
 * We use @NamedEntityGraph to specifying the attributes to include when we want to load the entity and the related associations.
 * Product is my NamedEntityGraph to load it and it's related Entities such as ProductBaseDetails,Guarantee.
 * We use @NamedAttributeNode to define the related entities to be loaded when the root entity is loaded.
 */
@NamedEntityGraph(name = "product-entity-graph",attributeNodes = {
        @NamedAttributeNode("guaranteeList"),
        @NamedAttributeNode("productBaseDetailList"),
        @NamedAttributeNode("projectList"),
        @NamedAttributeNode("supplier")
} )
@Entity(name = "Product")
@Table(name = "PRODUCTS",catalog = "ASM",schema = "test")
public class Product implements Serializable {

    private Long productId;
    private String name;
    private String health;
    private Date buyDate;
    private Set<Guarantee> guaranteeList;
    private Set<ProductBaseDetail> productBaseDetailList;
    private Set<Project> projectList;
    @JsonIgnore
    private Supplier supplier;
    private Long supplierId;



    public Product() {
        super();
    }

    public Product(Long productId, String name, String health, Date buyDate, Set<Guarantee> guaranteeList, Set<ProductBaseDetail> productBaseDetailList, Set<Project> projectList, Supplier supplier, Long supplierId) {
        this.productId = productId;
        this.name = name;
        this.health = health;
        this.buyDate = buyDate;
        this.guaranteeList = guaranteeList;
        this.productBaseDetailList = productBaseDetailList;
        this.projectList = projectList;
        this.supplier = supplier;
        this.supplierId = supplierId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Column(name = "PRODUCT_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "PRODUCT_HEALTH")
    public String getHealth() {
        return health;
    }

    @Column(name = "PRODUCT_BUY_DATE")
    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
    public Set<Guarantee> getGuaranteeList() {
        return guaranteeList;
    }

    public void setGuaranteeList(Set<Guarantee> guaranteeList) {
        this.guaranteeList = guaranteeList;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
    public Set<ProductBaseDetail> getProductBaseDetailList() {
        return productBaseDetailList;
    }

    public void setProductBaseDetailList(Set<ProductBaseDetail> productBaseDetailList) {
        this.productBaseDetailList = productBaseDetailList;
    }

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "productList")
    public Set<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(Set<Project> projectList) {
        this.projectList = projectList;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }


    @Transient
    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }


}
