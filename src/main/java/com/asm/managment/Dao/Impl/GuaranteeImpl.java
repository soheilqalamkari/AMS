package com.asm.managment.Dao.Impl;

import com.asm.managment.Dao.Interface.GuaranteeDao;
import com.asm.managment.Model.Guarantee;
import com.asm.managment.Service.Interface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProductService productService;


    @Override
    public void save(List<Guarantee> guarantee) {

        for (Guarantee guarantee1 : guarantee) {
            guarantee1.setProduct(productService.findProductById(guarantee1.getProductId()));
            entityManager.persist(guarantee1);
        }

    }

    @Override
    public Guarantee findById(Long guaranteeId) {
        return entityManager.find(Guarantee.class,guaranteeId);
    }

    @Override
    public List<Guarantee> findAllOrderByDuring() {
        Query query = entityManager.createQuery("SELECT g FROM Guarantee g order by g.during desc ",Guarantee.class);
       return query.getResultList();
    }

    @Override
    public List<Guarantee> findByDuring(Integer during) {
        Query query = entityManager.createQuery("select g from Guarantee g where g.during=:duringTime",Guarantee.class)
                .setParameter("duringTime",during);
        return query.getResultList();
    }

    @Override
    public List<Guarantee> findByNameAndDuring(String guaranteeName, Integer duringTime) {

        Query query = entityManager.createQuery("select g from Guarantee g where g.name=:guaranteeName and g.during=:duringTime",Guarantee.class)
                .setParameter("guaranteeName",guaranteeName)
                .setParameter("duringTime",duringTime);
        return query.getResultList();
    }

    @Override
    public List<Guarantee> findAllByNameOrderByDuring(String guaranteeName) {
        Query query = entityManager.createQuery("select g from Guarantee g where g.name=:guaranteeName order by g.during desc",Guarantee.class)
                .setParameter("guaranteeName",guaranteeName);
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
