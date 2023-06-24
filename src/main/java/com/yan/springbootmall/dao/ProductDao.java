package com.yan.springbootmall.dao;

import com.yan.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);
}
