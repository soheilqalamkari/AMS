package com.asm.managment.Service.Impl;


import com.asm.managment.Dao.Interface.ProductBaseDetailDao;
import com.asm.managment.Model.ProductBaseDetail;
import com.asm.managment.Service.Interface.ProductBaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBaseDetailServiceImpl implements ProductBaseDetailService{

    @Autowired
    private ProductBaseDetailDao productBaseDetailDao;

    @Override
    public void saveProductBaseDetail(ProductBaseDetail productBaseDetail) {
        productBaseDetailDao.save(productBaseDetail);
    }

    @Override
    public ProductBaseDetail findProductBaseDetailBySerialNo(Long serialNo) {
        return productBaseDetailDao.findBySerialNo(serialNo);
    }

    @Override
    public List<ProductBaseDetail> findAllProductBaseDetails() {
        return productBaseDetailDao.findAll();
    }

    @Override
    public void UpdateProductBaseDetail(ProductBaseDetail productBaseDetail) {
        productBaseDetailDao.Update(productBaseDetail);
    }

    @Override
    public void deleteProductBaseDetail(Long serialNo) {
        productBaseDetailDao.delete(serialNo);
    }

    @Override
    public void deleteAllProductBaseDetails() {
        productBaseDetailDao.deleteAll();
    }
}
