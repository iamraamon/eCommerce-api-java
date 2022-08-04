package com.shop.product.controller;

import com.shop.product.entity.ProductReviewEntity;
import com.shop.product.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productreview")
public class ProductReviewController {

    @Autowired
    private ProductReviewService productReviewService;

    @GetMapping
    public List<ProductReviewEntity> getOrderList(){
        return productReviewService.getProductReview();
    }

    @PostMapping
    public ProductReviewEntity saveOrder(@RequestBody ProductReviewEntity productReviewEntity){
        return productReviewService.saveProductReview(productReviewEntity);
    }

    @PutMapping
    public ProductReviewEntity updateOrder(@RequestBody ProductReviewEntity productReviewEntity){
        return productReviewService.saveProductReview(productReviewEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id){
        productReviewService.deleteProductReview(id);
        return "Deleted successfully";
    }
}
