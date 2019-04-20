package com.asm.managment.Dao.Impl;

import com.asm.managment.Dao.Interface.ProductDao;
import com.asm.managment.Model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    @org.springframework.data.jpa.repository.EntityGraph(value = "product-entity-graph",type = org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.LOAD)
    public Product findProductById(Long productId) {

            javax.persistence.EntityGraph entityGraph = entityManager.getEntityGraph("product-entity-graph");
           Product product = entityManager.createQuery("select p from Product p where p.productId = :id", Product.class)
                    .setParameter("id", productId)
                    .setHint("javax.persistence.fetchgraph", entityGraph)
                    .getResultList().stream().findFirst().orElse(null);
        return product;
//        EntityGraph entityGraph = entityManager.getEntityGraph("product-entity-graph");
//        Map<String,Object> properites = new HashMap<>();
//        properites.put("javax.persistence.fetchgraph",entityGraph);
//        Product product = entityManager.find(Product.class,productId,properites);
//        return product;
//        return entityManager.find(Product.class,productId);
    }

    @Override
    public List<Product> findProducts() {

        //Query query = entityManager.createQuery("SELECT p FROM  Product p join p.productBaseDetailList d where p.id=:id")
//        Query query = entityManager.createQuery("select p from Product p");
//        query.getResultList();
//        return query.getResultList();

        Query query = entityManager.createQuery("select p from Product p");
        return query.getResultList();
    }

    @Override
    public void update(Product product) {
        Product productInstance = findProductById(product.getProductId());
        productInstance.setName(product.getName());
        productInstance.setHealth(product.getHealth());
        productInstance.setGuaranteeList(product.getGuaranteeList());
        productInstance.setProductBaseDetailList(product.getProductBaseDetailList());
        entityManager.merge(productInstance);
    }

    @Override
    public void delete(Long productId) {
        entityManager.remove(productId);
    }

    @Override
    public void deleteAll() {
        Query query = entityManager.createQuery("DELETE FROM Product");
        query.executeUpdate();
    }
}
