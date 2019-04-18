package com.asm.managment.Controller;

import com.asm.managment.Dao.Interface.ProductDao;
import com.asm.managment.Model.Product;
import com.asm.managment.Service.Interface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/api/v1.0/all")
    public ResponseEntity<List<Product>> all(){
        List<Product> productList;
        productList = productService.findAllProducts();
        return new ResponseEntity<>(productList,HttpStatus.OK);
    }

    @PostMapping(value = "/api/v1.0/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
