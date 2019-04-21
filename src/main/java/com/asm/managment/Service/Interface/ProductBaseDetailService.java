package com.asm.managment.Service.Interface;

import com.asm.managment.Model.ProductBaseDetail;

import java.util.List;

public interface ProductBaseDetailService {

    void saveProductBaseDetail(ProductBaseDetail productBaseDetail);
    ProductBaseDetail findProductBaseDetailBySerialNo(Long serialNo);
    List<ProductBaseDetail> findAllProductBaseDetails();
    void UpdateProductBaseDetail(ProductBaseDetail productBaseDetail);
    void deleteProductBaseDetail(Long serialNo);
    void deleteAllProductBaseDetails();
}
