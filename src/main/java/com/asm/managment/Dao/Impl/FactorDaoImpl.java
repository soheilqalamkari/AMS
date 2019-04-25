package com.asm.managment.Dao.Impl;

import com.asm.managment.Dao.Interface.FactorDao;
import com.asm.managment.Model.Factor;
import com.asm.managment.Service.Interface.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class FactorDaoImpl implements FactorDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private SupplierService supplierService;

    @Override
    public void save(Factor factor) {
        factor.setSupplier(supplierService.findSupplierById(factor.getSupplierId()));
        entityManager.persist(factor);
    }

    @Override
    public Factor findFactorById(Long factorId) {
       return entityManager.find(Factor.class,factorId);
    }

    @Override
    public List<Factor> findFactors() {
        Query query = entityManager.createQuery("SELECT f FROM Factor f",Factor.class);
       return query.getResultList();
    }

    @Override
    public List<Factor> findFactorsByDate(Date date) {
        Query query = entityManager.createQuery("SELECT f FROM Factor f where f.date=:date")
                .setParameter("date",date);
        return query.getResultList();
    }

    @Override
    public void update(Factor factor) {
        Factor factorObj = findFactorById(factor.getFactorId());
        //factor.setSupplier(supplierService.findSupplierById(factor.getSupplierId()));
        factorObj.setDate(factor.getDate());
        factorObj.setSupplier(factor.getSupplier());
         entityManager.merge(factorObj);
    }

    @Override
    public void delete(Long factorId) {
        entityManager.remove(findFactorById(factorId));
    }

    @Override
    public void deleteAll() {
        Query query = entityManager.createQuery("DELETE from Factor");
        query.executeUpdate();
    }
}
