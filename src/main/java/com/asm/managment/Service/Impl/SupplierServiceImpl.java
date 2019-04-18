package com.asm.managment.Service.Impl;

import com.asm.managment.Dao.Interface.SupplierDao;
import com.asm.managment.Model.Supplier;
import com.asm.managment.Service.Interface.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDao supplierDao;

    @Override
    public void save(Supplier supplier) {
        supplierDao.save(supplier);
    }

    @Override
    public Supplier findSupplierById(Long supplierId) {
        return supplierDao.findById(supplierId);
    }

    @Override
    public Supplier findSupplerByPhoneNumber(Long supplerPhoneNumber) {
        return supplierDao.findByPhoneNumber(supplerPhoneNumber);
    }

    @Override
    public List<Supplier> findSuppliers() {
        return supplierDao.findAll();
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierDao.update(supplier);
    }

    @Override
    public void deleteSupplier(Long supplierId) {
         supplierDao.delete(supplierId);
    }

    @Override
    public void deleteAllSuppliers() {
        supplierDao.deleteAll();
    }
}
