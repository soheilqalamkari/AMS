package com.asm.managment.Dao.Interface;

import com.asm.managment.Model.Supplier;

import java.util.List;


public interface SupplierDao {


    void save(Supplier supplier);
    Supplier findById(Long supplierId);
    Supplier findByPhoneNumber(Long supplerPhoneNumber);
    List<Supplier> findAll();
    void update(Supplier Supplier);
    void delete(Long SupplierId);
    void deleteAll();

}
