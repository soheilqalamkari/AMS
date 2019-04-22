package com.asm.managment.Dao.Interface;

import com.asm.managment.Model.Supplier;

import java.util.List;


public interface SupplierDao {


    void save(Supplier supplier);
    Supplier findById(Long supplierId);
    Supplier findByName(String supplierName);
    Supplier findByPhone(Long supplierPhone);
    Supplier findByNameAndPhone(String supplierName,Long supplierPhone);
    List<Supplier> findAll();
    void update(Supplier Supplier);
    void delete(Long SupplierId);
    void deleteAll();

}
