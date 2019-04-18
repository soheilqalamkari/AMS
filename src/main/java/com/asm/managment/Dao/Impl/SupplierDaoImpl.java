package com.asm.managment.Dao.Impl;

import com.asm.managment.Dao.Interface.SupplierDao;
import com.asm.managment.Model.Supplier;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SupplierDaoImpl implements SupplierDao {

    @PersistenceContext
   private EntityManager entityManager;

    @Override
    public void save(Supplier supplier) {
        entityManager.persist(supplier);
    }

    @Override
    public Supplier findById(Long supplierId) {
        return entityManager.find(Supplier.class,supplierId);
    }

    @Override
    public Supplier findByPhoneNumber(Long supplierPhoneNumber) {
        return entityManager.find(Supplier.class,supplierPhoneNumber);
    }

    @Override
    @SuppressWarnings("Unchecked assignment")
    public List<Supplier> findAll() {
       Query query = entityManager.createQuery(" select s from Supplier s ",Supplier.class);
       return query.getResultList();
    }

    @Override
    public void update(Supplier supplier) {
        Supplier supp  = findById(supplier.getSupplierId());
        supp.setName(supp.getName());
        supp.setPhone(supp.getPhone());
        entityManager.merge(supp);
    }

    @Override
    public void delete(Long supplierId) {
        entityManager.remove(findById(supplierId));
    }

    @Override
    public void deleteAll() {
        entityManager.createNativeQuery("DELETE FROM system.suppliers").executeUpdate();
    }
}
