package com.asm.managment.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "FACTORS",catalog = "ASM",schema = "test")
public class Factor implements Serializable {

    private Long factorId;
    private Date date;
    @JsonIgnore
    private Supplier supplier;
    private Long supplierId;


    public Factor() {
        super();
    }

    public Factor(Long factorId, Date date, Supplier supplier, Long supplierId) {
        this.factorId = factorId;
        this.date = date;
        this.supplier = supplier;
        this.supplierId = supplierId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FACTOR_ID")
    public Long getFactorId() {
        return factorId;
    }

    public void setFactorId(Long factorId) {
        this.factorId = factorId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Column(name = "FACTOR_DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Transient
    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }


}
