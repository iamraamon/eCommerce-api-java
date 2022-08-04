package com.shop.order.service;

import com.shop.order.entity.OrderEntity;
import com.shop.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderEntity> getOrder(){
        return orderRepository.findAll();
    }

    public OrderEntity saveOrder(OrderEntity orderEntity){
        return orderRepository.save(orderEntity);
    }

    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }
}
