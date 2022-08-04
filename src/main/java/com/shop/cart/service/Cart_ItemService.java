package com.shop.cart.service;

import com.shop.cart.entity.Cart_ItemEntity;
import com.shop.cart.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Cart_ItemService {

    @Autowired
    private CartItemRepository cartItemRepository;


    public List<Cart_ItemEntity> getCartItem(){
        return cartItemRepository.findAll();
    }

    public Cart_ItemEntity saveCartItem(Cart_ItemEntity cart_itemEntity){
        return cartItemRepository.save(cart_itemEntity);
    }

    public void deleteCartItem(Long id){
        cartItemRepository.deleteById(id);
    }
}
