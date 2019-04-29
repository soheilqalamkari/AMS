package com.asm.managment.Service.Interface;

import com.asm.managment.Model.Product;
import com.asm.managment.Model.ProductBaseDetail;

import java.util.List;

public interface ProductService {

    void saveProduct(Product product);
    Product findProductById(Long productId);
    Product findProductByDetails(Long productId);
    List<Product> findAllProducts();
    void updateProduct(Product product);
    void deleteProduct(Long product);
    void deleteAllProducts();

}
