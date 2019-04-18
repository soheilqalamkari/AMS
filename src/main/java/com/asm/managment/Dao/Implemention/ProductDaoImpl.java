package com.asm.managment.Dao.Implemention;

import com.asm.managment.Dao.Interface.ProductDao;
import com.asm.managment.Model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    public Product findProductById(Long productId) {
        return entityManager.find(Product.class,productId);
    }

    @Override
    public List<Product> findProducts() {

        //Query query = entityManager.createQuery("SELECT p FROM  Product p join p.productBaseDetailList d where p.id=:id")
        Query query = entityManager.createQuery("select p from Product p");
        query.getResultList();
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
