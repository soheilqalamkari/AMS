package com.asm.managment.Service.Interface;

import com.asm.managment.Model.Supplier;

import java.util.List;

public interface SupplierService {

    void save(Supplier supplier);
    Supplier findSupplierById(Long supplierId);
    Supplier findSupplerByPhoneNumber(Long supplerPhoneNumber);
    List<Supplier> findSuppliers();
    void updateSupplier(Supplier Supplier);
    void deleteSupplier(Long SupplierId);
    void deleteAllSuppliers();
}
