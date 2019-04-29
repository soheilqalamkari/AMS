package com.asm.managment.Service.Impl;

import com.asm.managment.Dao.Interface.ProductDao;
import com.asm.managment.Model.Product;
import com.asm.managment.Model.ProductBaseDetail;
import com.asm.managment.Service.Interface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductDao productDao;

    @Override
    public void saveProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public Product findProductById(Long productId) {
        return productDao.findProductById(productId);
    }

    @Override
    public Product findProductByDetails(Long productId) {
        return productDao.findProductByDetails(productId);
    }

    @Override
    public List<Product> findAllProducts() {
        return productDao.findProducts();
    }

    @Override
    public void updateProduct(Product product) {
        productDao.update(product);
    }

    @Override
    public void deleteProduct(Long product) {
        productDao.delete(product);
    }

    @Override
    public void deleteAllProducts() {
        productDao.deleteAll();
    }
}
