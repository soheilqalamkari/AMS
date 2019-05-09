//package com.asm.managment.Model;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//@Table(name = "PRODUCT_IN_PROJECT",schema = "test",catalog = "myDB")
//public class ProductInProject implements Serializable{
//
//    private Long productId;
//    private Long projectId;
////    private Product product;
////    private Project project;
//
//    private Long prodId;
//    private Long projId;
//
//
//    public ProductInProject() {
//        super();
//    }
//
//    public ProductInProject(Long productId, Long projectId, Product product, Project project, Long prodId, Long projId) {
//        this.productId = productId;
//        this.projectId = projectId;
////        this.product = product;
////        this.project = project;
//        this.prodId = prodId;
//        this.projId = projId;
//    }
//
//    @Id
//    @Column(name = "PRODUCT_ID")
//    public Long getProductId() {
//        return productId;
//    }
//
//    public void setProductId(Long productId) {
//        this.productId = productId;
//    }
//
//    @Id
//    @Column(name = "PROJECT_ID")
//    public Long getProjectId() {
//        return projectId;
//    }
//
//    public void setProjectId(Long projectId) {
//        this.projectId = projectId;
//    }
//
////    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
////    public Product getProduct() {
////        return product;
////    }
////
////    public void setProduct(Product product) {
////        this.product = product;
////    }
////
////    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
////    public Project getProject() {
////        return project;
////    }
////
////    public void setProject(Project project) {
////        this.project = project;
////    }
//
//    @Transient
//    public Long getProdId() {
//        return prodId;
//    }
//
//    public void setProdId(Long prodId) {
//        this.prodId = prodId;
//    }
//
//    @Transient
//    public Long getProjId() {
//        return projId;
//    }
//
//    public void setProjId(Long projId) {
//        this.projId = projId;
//    }
//}
