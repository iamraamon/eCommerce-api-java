package com.shop.order.service;

import com.shop.order.entity.Order_ItemEntity;
import com.shop.order.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Order_ItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<Order_ItemEntity> getOrderItem(){
        return orderItemRepository.findAll();
    }

    public Order_ItemEntity saveOrderItem(Order_ItemEntity orderItemEntity){
        return orderItemRepository.save(orderItemEntity);
    }

    public void deleteOrderItem(Long id){
        orderItemRepository.deleteById(id);
    }
}
