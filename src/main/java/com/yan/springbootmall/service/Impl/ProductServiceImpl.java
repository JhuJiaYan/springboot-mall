package com.yan.springbootmall.service.Impl;

import com.yan.springbootmall.dao.ProductDao;
import com.yan.springbootmall.model.Product;
import com.yan.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
