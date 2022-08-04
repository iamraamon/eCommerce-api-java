package com.shop.order.repository;

import com.shop.order.entity.Order_ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<Order_ItemEntity,Long> {
}
