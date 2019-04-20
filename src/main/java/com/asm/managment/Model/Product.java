package com.asm.managment.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * We use @NamedEntityGraph to specifying the attributes to include when we want to load the entity and the related associations.
 * Product is my NamedEntityGraph to load it and it's related Entities such as ProductBaseDetails,Guarantee.
 * We use @NamedAttributeNode to define the related entities to be loaded when the root entity is loaded.
 */
@NamedEntityGraph(name = "product-entity-graph",attributeNodes = {
        @NamedAttributeNode("guaranteeList"),
        @NamedAttributeNode("productBaseDetailList")
} )
@Entity(name = "Product")
@Table(name = "PRODUCTS",catalog = "ASM",schema = "system")
public class Product implements Serializable {

    private Long productId;
    private String name;
    private String health;
    private Date buyDate;
    private Set<Guarantee> guaranteeList;
    private Set<ProductBaseDetail> productBaseDetailList;

    public Product() {
        super();
    }

    public Product(Long productId, String name, String health, Date buyDate, Set<Guarantee> guaranteeList, Set<ProductBaseDetail> productBaseDetailList) {
        this.productId = productId;
        this.name = name;
        this.health = health;
        this.buyDate = buyDate;
        this.guaranteeList = guaranteeList;
        this.productBaseDetailList = productBaseDetailList;
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
}
