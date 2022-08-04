package com.shop.product.service;

import com.shop.product.entity.ProductMetaEntity;
import com.shop.product.repository.ProductMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMetaService {

    @Autowired
    private ProductMetaRepository productMetaRepository;

    public List<ProductMetaEntity> getProductMeta(){
        return productMetaRepository.findAll();
    }

    public ProductMetaEntity saveProductMeta(ProductMetaEntity productMetaEntity){
        return productMetaRepository.save(productMetaEntity);
    }

    public void deleteProductMeta(Long id){
        productMetaRepository .deleteById(id);
    }
}
