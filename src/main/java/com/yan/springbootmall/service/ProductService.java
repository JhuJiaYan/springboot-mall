package com.yan.springbootmall.service;

import com.yan.springbootmall.constant.ProductCategory;
import com.yan.springbootmall.dto.ProductRequest;
import com.yan.springbootmall.model.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Integer productId);

    List<Product> getProducts(ProductCategory category,String search);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);


}
