package com.asm.managment.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "PROJECTS",catalog = "ASM",schema = "system")
public class Project implements Serializable{

    private Long projectId;
    private String name;
    private Date beginDate;
    private Date endDate;
    private Set<Product> productSet;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_ID")
    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @Column(name = "PROJECT_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "PROJECT_BEGIN_DATE")
    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    @Column(name = "PROJECT_END_DATE")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @ManyToMany
    @JoinTable(name = "PRODUCT_IN_PROJECT",joinColumns = @JoinColumn(name = "PROJECT_ID"),inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }
}
