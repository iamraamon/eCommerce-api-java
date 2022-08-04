package com.shop.cart.repository;

import com.shop.cart.entity.Cart_ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<Cart_ItemEntity,Long> {
}
