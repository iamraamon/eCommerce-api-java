package com.shop.product.controller;

import com.shop.product.entity.ProductMetaEntity;
import com.shop.product.service.ProductMetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productmeta")
public class ProductMetaController {

    @Autowired
    private ProductMetaService productMetaService;

    @GetMapping
    public List<ProductMetaEntity> getOrderList(){
        return productMetaService.getProductMeta();
    }

    @PostMapping
    public ProductMetaEntity saveOrder(@RequestBody ProductMetaEntity productMetaEntity){
        return productMetaService.saveProductMeta(productMetaEntity);
    }

    @PutMapping
    public ProductMetaEntity updateOrder(@RequestBody ProductMetaEntity productMetaEntity){
        return productMetaService.saveProductMeta(productMetaEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id){
        productMetaService.deleteProductMeta(id);
        return "Deleted successfully";
    }
}
