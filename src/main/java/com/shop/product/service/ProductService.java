package com.shop.product.service;

import com.shop.product.entity.ProductEntity;
import com.shop.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getProduct(){
        return productRepository.findAll();
    }

    public ProductEntity saveProduct(ProductEntity productEntity){
        return productRepository.save(productEntity);
    }

    public void deleteProduct(Long id){
        productRepository .deleteById(id);
    }
}
