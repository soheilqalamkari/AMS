package com.asm.managment.Dao.Interface;

import com.asm.managment.Model.Product;

import java.util.List;

public interface ProductDao {

    void save(Product product);
    Product findProductById(Long productId);
    List<Product> findProducts();
    void update(Product product);
    void delete(Long product);
    void deleteAll();
}
