package com.asm.managment.Controller;

import com.asm.managment.Model.Product;
import com.asm.managment.Service.Interface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/api/v1.0/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> all(){
        List<Product> productList;
        productList = productService.findAllProducts();
        return new ResponseEntity<>(productList,HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1.0/find/{productId}")
    public ResponseEntity<Product> findProductById(@PathVariable Long productId){
        return new ResponseEntity<>(productService.findProductById(productId),HttpStatus.OK);
    }

    @PostMapping(value = "/api/v1.0/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/api/v1.0/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/v1.0/delete/{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/v1.0/delete")
    public ResponseEntity<Product> deleteAllProducts(){
        productService.deleteAllProducts();
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
