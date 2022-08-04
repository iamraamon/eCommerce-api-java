package com.shop.cart.controller;

import com.shop.cart.entity.CartEntity;
import com.shop.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public List<CartEntity> getCartList(){
        return cartService.getCart();
    }

    @PostMapping
    public CartEntity saveCart(@RequestBody CartEntity cartEntity){
        return cartService.saveCart(cartEntity);
    }

    @PutMapping
    public CartEntity updateCart(@RequestBody CartEntity cartEntity){
        return cartService.saveCart(cartEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteCart(@PathVariable Long id){
        cartService.deleteCart(id);
        return "Deleted successfully";
    }
}
