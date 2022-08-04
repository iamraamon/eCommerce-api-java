package com.shop.product.controller;

import com.shop.product.entity.ProductEntity;
import com.shop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductEntity> getOrderList(){
        return productService.getProduct();
    }

    @PostMapping
    public ProductEntity saveOrder(@RequestBody ProductEntity productEntity){
        return productService.saveProduct(productEntity);
    }

    @PutMapping
    public ProductEntity updateOrder(@RequestBody ProductEntity productEntity){
        return productService.saveProduct(productEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Deleted successfully";
    }
}
