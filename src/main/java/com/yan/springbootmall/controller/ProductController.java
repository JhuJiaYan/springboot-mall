package com.yan.springbootmall.controller;

import com.yan.springbootmall.constant.ProductCategory;
import com.yan.springbootmall.dto.ProductQueryParams;
import com.yan.springbootmall.dto.ProductRequest;
import com.yan.springbootmall.model.Product;
import com.yan.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 查詢商品
     * @param productId
     * @return
     */
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * 查詢商品列表
     * @return
     */
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(
            //required = false 讓category參數變成可選參數(非必要)
            @RequestParam(required = false) ProductCategory category,//商品分類
            @RequestParam(required = false) String search //使用者搜尋關鍵字
    ){
        ProductQueryParams productQueryParams=new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);

        //List<Product> productList=productService.getProducts(category,search);
        List<Product> productList=productService.getProducts(productQueryParams);

        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    /**
     * 新增商品
     *
     * @param productRequest
     * @return
     */
    @PostMapping("/products")
    //@Valid使驗證請求參數註解生效，如@NotNull
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        Integer productId = productService.createProduct(productRequest);//創建新的商品並將id傳回來
        Product product = productService.getProductById(productId);//依傳回來的id從資料庫取得剛創建好的商品資了
        return ResponseEntity.status(HttpStatus.CREATED).body(product);//回傳給前端狀態碼與商品資料
    }

    /**
     * 修改商品
     *
     * @return
     */
    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest) {

        //先查詢商品是否存在
        Product product = productService.getProductById(productId);
        if (product == null) {//若不存在
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();//返回不存在404給前端
        }
        //若存在就更新商品資料
        productService.updateProduct(productId, productRequest);//更新商品資料
        Product updateOK = productService.getProductById(productId);//查詢更新後的商品資料
        return ResponseEntity.status(HttpStatus.OK).body(updateOK);//將更新後的商品資料返回前端

    }

    /**
     * 刪除商品
     * @param productId
     * @return
     */
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        productService.deleteProductById(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
