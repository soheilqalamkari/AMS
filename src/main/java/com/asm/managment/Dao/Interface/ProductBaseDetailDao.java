package com.asm.managment.Dao.Interface;

import com.asm.managment.Model.ProductBaseDetail;

import java.util.List;

public interface ProductBaseDetailDao  {

    void save(ProductBaseDetail productBaseDetail);
    ProductBaseDetail findBySerialNo(Long productBaseDetailId);
    List<ProductBaseDetail> findAll();
    void Update(ProductBaseDetail productBaseDetail);
    void delete(Long productBaseDetailId);
    void deleteAll();
}
