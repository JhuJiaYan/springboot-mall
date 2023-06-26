package com.yan.springbootmall.service;

import com.yan.springbootmall.dto.ProductRequest;
import com.yan.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

}
