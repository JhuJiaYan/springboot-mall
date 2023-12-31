package com.yan.springbootmall.dao;

import com.yan.springbootmall.dto.ProductQueryParams;
import com.yan.springbootmall.dto.ProductRequest;
import com.yan.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {


    Product getProductById(Integer productId);

    //List<Product> getProducts(ProductCategory category,String search);
    List<Product> getProducts(ProductQueryParams productQueryParams);

    Integer countProduct(ProductQueryParams productQueryParams);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

    void updateStock(Integer productId, Integer stock);
}
