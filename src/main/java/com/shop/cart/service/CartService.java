package com.shop.cart.service;

import com.shop.cart.entity.CartEntity;
import com.shop.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<CartEntity> getCart(){
        return cartRepository.findAll();
    }

    public CartEntity saveCart(CartEntity cartEntity){
        return cartRepository.save(cartEntity);
    }

    public void deleteCart(Long id){
        cartRepository.deleteById(id);
    }

}
