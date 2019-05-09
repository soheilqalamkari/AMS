package com.asm.managment.Dao.Impl;

import com.asm.managment.Dao.Interface.ProductDao;
import com.asm.managment.Model.Product;
import com.asm.managment.Model.ProductBaseDetail;
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
    public Product findProductByDetails(Long productId) {
        try {
            Product productTypedQuery = entityManager.createQuery("select p from  Product p join fetch p.productBaseDetailList b join fetch p.guaranteeList g join fetch p.supplier s where b.product.productId=:productId",Product.class)
                    .setParameter("productId",productId)
                    .getSingleResult();
            return productTypedQuery;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    //@org.springframework.data.jpa.repository.EntityGraph(type = org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.LOAD)
    public List<Product> findProducts() {


        try{
            Query query = entityManager.createQuery("select p from Product p",Product.class);
           return query.getResultList();
        }catch (NoResultException e){
            return null;
        }
//        EntityGraph entityGraph = entityManager.getEntityGraph("product-entity-graph");
//        List<Product> productList =  entityManager.createQuery("select p from Product p",Product.class)
//                .setHint("javax.persistence.fetchgraph",entityGraph)
//                .getResultList();
//        return productList;
    }

    @Override
    public void update(Product product) {
//        Product productInstance = findProductById(product.getProductId());
//        productInstance.setName(product.getName());
//        productInstance.setHealth(product.getHealth());
//        productInstance.setGuaranteeList(product.getGuaranteeList());
//        productInstance.setProductBaseDetailList(product.getProductBaseDetailList());
//        entityManager.merge(productInstance);
    }

    @Override
    public void delete(Long productId)
    {
        entityManager.remove(findProductById(productId));
    }

    @Override
    public void deleteAll() {
        Query query = entityManager.createQuery("DELETE FROM Product");
        query.executeUpdate();
    }
}
