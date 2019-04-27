package com.asm.managment.Wrapper;

import com.asm.managment.Model.Factor;
import com.asm.managment.Model.Guarantee;
import com.asm.managment.Model.Product;
import com.asm.managment.Model.ProductBaseDetail;

import java.util.List;

public class ProductRequestWrapper {

    private Product product;
    private ProductBaseDetail productBaseDetail;
    private List<Guarantee> guaranteeList;


    public ProductRequestWrapper() {
        super();
    }

    public ProductRequestWrapper(Product product, ProductBaseDetail productBaseDetail, List<Guarantee> guaranteeList) {
        this.product = product;
        this.productBaseDetail = productBaseDetail;
        this.guaranteeList = guaranteeList;
    }

    public List<Guarantee> getGuaranteeList() {
        return guaranteeList;
    }

    public void setGuaranteeList(List<Guarantee> guaranteeList) {
        this.guaranteeList = guaranteeList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductBaseDetail getProductBaseDetail() {
        return productBaseDetail;
    }

    public void setProductBaseDetail(ProductBaseDetail productBaseDetail) {
        this.productBaseDetail = productBaseDetail;
    }
}
