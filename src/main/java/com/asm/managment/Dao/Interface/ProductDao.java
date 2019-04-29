package com.asm.managment.Dao.Interface;

import com.asm.managment.Model.Product;
import com.asm.managment.Model.ProductBaseDetail;

import java.util.List;

public interface ProductDao {

    void save(Product product);
    Product findProductById(Long productId);
    List<Product> findProducts();
    Product findProductByDetails(Long productId);
    void update(Product product);
    void delete(Long product);
    void deleteAll();
}
