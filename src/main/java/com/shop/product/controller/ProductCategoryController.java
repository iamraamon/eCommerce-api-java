package com.shop.product.controller;

import com.shop.product.entity.ProductCategoryEntity;
import com.shop.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productcategory")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping
    public List<ProductCategoryEntity> getOrderList(){
        return productCategoryService.getProductCategory();
    }

    @PostMapping
    public ProductCategoryEntity saveOrder(@RequestBody ProductCategoryEntity productCategoryEntity){
        return productCategoryService.saveProductCategory(productCategoryEntity);
    }

    @PutMapping
    public ProductCategoryEntity updateOrder(@RequestBody ProductCategoryEntity productCategoryEntity){
        return productCategoryService.saveProductCategory(productCategoryEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id){
        productCategoryService.deleteProductCategory(id);
        return "Deleted successfully";
    }
}
