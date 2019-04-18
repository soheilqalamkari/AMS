package com.asm.managment.Dao.Interface;

import com.asm.managment.Model.Factor;
import com.asm.managment.Model.Product;

import java.util.List;

public interface ProductDao {

    void save(Product product);
    Product findProductById(Long productId);
    List<Product> findProducts();
    List<Product> findAll();
    void update(Product product);
    void delete(Long product);
    void deleteAll();
}
