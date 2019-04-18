package com.asm.managment.Dao.Impl;

import com.asm.managment.Dao.Interface.GuaranteeDao;
import com.asm.managment.Model.Guarantee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GuaranteeImpl implements GuaranteeDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(Guarantee guarantee) {
        entityManager.persist(guarantee);
    }

    @Override
    public Guarantee findById(Long guaranteeId) {
        return entityManager.find(Guarantee.class,guaranteeId);
    }

    @Override
    public List<Guarantee> findAll() {
        Query query = entityManager.createQuery("SELECT g FROM Guarantee g",Guarantee.class);
       return query.getResultList();
    }

    @Override
    public void update(Guarantee guarantee) {
        Guarantee gu = findById(guarantee.getGuaranteeId());
        gu.setName(guarantee.getName());
        gu.setDetails(guarantee.getDetails());
        gu.setDuring(guarantee.getDuring());
        //gu.setProduct();
        entityManager.merge(gu);
    }

    @Override
    public void delete(Long guaranteeId) {
        entityManager.remove(guaranteeId);
    }

    @Override
    public void deleteAll() {
        Query query = entityManager.createQuery("DELETE FROM Guarantee");
        query.executeUpdate();
    }
}
