package com.shop.cart.controller;

import com.shop.cart.entity.Cart_ItemEntity;
import com.shop.cart.service.Cart_ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartitem")
public class Cart_ItemController {

    @Autowired
    private Cart_ItemService cart_ItemService;

    @GetMapping
    public List<Cart_ItemEntity> getCartItemList(){
        return cart_ItemService.getCartItem();
    }

    @PostMapping
    public Cart_ItemEntity saveCartItem(@RequestBody Cart_ItemEntity cart_itemEntity){
        return cart_ItemService.saveCartItem(cart_itemEntity);
    }

    @PutMapping
    public Cart_ItemEntity updateCartItem(@RequestBody Cart_ItemEntity cart_itemEntity){
        return cart_ItemService.saveCartItem(cart_itemEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteCartItem(@PathVariable Long id){
        cart_ItemService.deleteCartItem(id);
        return "Deleted successfully";
    }
}
