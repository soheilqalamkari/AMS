package com.asm.managment.Controller;

import com.asm.managment.Model.Guarantee;
import com.asm.managment.Model.Product;
import com.asm.managment.Model.ProductBaseDetail;
import com.asm.managment.Service.Interface.GuaranteeService;
import com.asm.managment.Service.Interface.ProductBaseDetailService;
import com.asm.managment.Service.Interface.ProductService;
import com.asm.managment.Wrapper.ProductRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.ManyToMany;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "Product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductBaseDetailService productBaseDetailService;

    @Autowired
    private GuaranteeService guaranteeService;


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

//    @PostMapping(value = "/api/v1.0/save",consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Product> saveProduct(@RequestBody Product product,@RequestBody ProductBaseDetail productBaseDetail){
//        productService.saveProduct(product);
//        productBaseDetailService.saveProductBaseDetail(productBaseDetail);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

        @PostMapping(value = "/api/v1.0/save",consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Product> saveProduct(@RequestBody ProductRequestWrapper productRequestWrapper){
        productService.saveProduct(productRequestWrapper.getProduct());
        productBaseDetailService.saveProductBaseDetail(productRequestWrapper.getProductBaseDetail());
        guaranteeService.saveGuarantee(productRequestWrapper.getGuaranteeList());
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


    @GetMapping(value = "/api/v1.0/ProductsInfo",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductBaseDetail>> allDetails(){
        productBaseDetailService.findAllProductBaseDetails();
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping(value = "/api/v1.0/Adddetail",consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ProductBaseDetail> saveBaseProductDetail(@RequestBody ProductBaseDetail productBaseDetail){
//        productBaseDetailService.saveProductBaseDetail(productBaseDetail);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @GetMapping(value = "/api/v1.0/details/{productId}")
    public ResponseEntity<Product> showProductByBaseDetails(@PathVariable Long productId){
        try{
            Product product = productService.findProductByDetails(productId);
            return new ResponseEntity<>(product,HttpStatus.OK);
        }catch (NoResultException e){
            return null;
        }
    }



}
