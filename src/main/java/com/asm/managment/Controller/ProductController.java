package com.asm.managment.Controller;

import com.asm.managment.Dao.Interface.ProductDao;
import com.asm.managment.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "Product")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping(value = "/api/v1.0/all")
    public ResponseEntity<List<Product>> all(){
        List<Product> productList;
      productList = productDao.findProducts();
        return new ResponseEntity<>(productList,HttpStatus.OK);
    }

}
