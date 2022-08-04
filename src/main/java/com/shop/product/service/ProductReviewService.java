package com.shop.product.service;

import com.shop.product.entity.ProductReviewEntity;
import com.shop.product.repository.ProductReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReviewService {

    @Autowired
    private ProductReviewRepository productReviewRepository;

    public List<ProductReviewEntity> getProductReview(){
        return productReviewRepository.findAll();
    }

    public ProductReviewEntity saveProductReview(ProductReviewEntity productReviewEntity){
        return productReviewRepository.save(productReviewEntity);
    }

    public void deleteProductReview(Long id){
        productReviewRepository .deleteById(id);
    }
}
