package com.asm.managment.Service.Interface;

import com.asm.managment.Model.Supplier;

import java.util.List;

public interface SupplierService {

    void save(Supplier supplier);
    Supplier findSupplierById(Long supplierId);
    Supplier findByName(String supplierName);
    Supplier findByPhone(Long supplierPhone);
    Supplier findByNameAndPhone(String supplierName,Long supplierPhone);
    List<Supplier> findSuppliers();
    void updateSupplier(Supplier Supplier);
    void deleteSupplier(Long SupplierId);
    void deleteAllSuppliers();
}
