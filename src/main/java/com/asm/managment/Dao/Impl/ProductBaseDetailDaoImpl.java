package com.asm.managment.Dao.Impl;

import com.asm.managment.Dao.Interface.ProductBaseDetailDao;
import com.asm.managment.Model.ProductBaseDetail;
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
public class ProductBaseDetailDaoImpl implements ProductBaseDetailDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProductService productService;

    @Override
    public void save(ProductBaseDetail productBaseDetail) {

        productBaseDetail.setProduct(productService.findProductById(productBaseDetail.getProductId()));
        entityManager.persist(productBaseDetail);
    }

    @Override
    public ProductBaseDetail findBySerialNo(Long serialNo) {
        return entityManager.find(ProductBaseDetail.class,serialNo);
    }

    @Override
    public List<ProductBaseDetail> findAll() {
        List<ProductBaseDetail> productBaseDetailList;
        Query query = entityManager.createQuery("select b from ProductBaseDetail b",ProductBaseDetail.class);
        productBaseDetailList = query.getResultList();
        return productBaseDetailList;
    }

    @Override
    public void Update(ProductBaseDetail productBaseDetail) {
        ProductBaseDetail productBaseDetailInstance = findBySerialNo(productBaseDetail.getSerialNo());
        productBaseDetailInstance.setModelNo(productBaseDetail.getModelNo());
        productBaseDetailInstance.setPartNo(productBaseDetailInstance.getPartNo());
        productBaseDetailInstance.setSerialNo(productBaseDetailInstance.getSerialNo());
        entityManager.merge(productBaseDetailInstance);
    }

    @Override
    public void delete(Long productBaseDetailId) {
        Query query = entityManager.createQuery("delete from productBaseDetail b where b.baseDetail =:id")
                .setParameter("id",productBaseDetailId);
        query.executeUpdate();
    }

    @Override
    public void deleteAll() {
        Query query = entityManager.createQuery("delete from ProductBaseDetail",ProductBaseDetail.class);
        query.executeUpdate();
    }
}
