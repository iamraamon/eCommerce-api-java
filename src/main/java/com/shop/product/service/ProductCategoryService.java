package com.shop.product.service;

import com.shop.product.entity.ProductCategoryEntity;
import com.shop.product.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public List<ProductCategoryEntity> getProductCategory(){
        return productCategoryRepository.findAll();
    }

    public ProductCategoryEntity saveProductCategory(ProductCategoryEntity productCategoryEntity){
        return productCategoryRepository.save(productCategoryEntity);
    }

    public void deleteProductCategory(Long id){
        productCategoryRepository.deleteById(id);
    }
}
