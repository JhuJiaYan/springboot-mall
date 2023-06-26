package com.yan.springbootmall.controller;

import com.yan.springbootmall.dto.ProductRequest;
import com.yan.springbootmall.model.Product;
import com.yan.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping("/products")
    //@Valid使驗證請求參數註解生效，如@NotNull
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        Integer productId = productService.createProduct(productRequest);//創建新的商品並將id傳回來
        Product product = productService.getProductById(productId);//依傳回來的id從資料庫取得剛創建好的商品資了
        return ResponseEntity.status(HttpStatus.CREATED).body(product);//回傳給前端狀態碼與商品資料
    }
}
