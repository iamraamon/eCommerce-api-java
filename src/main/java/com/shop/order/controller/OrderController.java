package com.shop.order.controller;

import com.shop.order.entity.OrderEntity;
import com.shop.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderEntity> getOrderList(){
        return orderService.getOrder();
    }

    @PostMapping
    public OrderEntity saveOrder(@RequestBody OrderEntity orderEntity){
        return orderService.saveOrder(orderEntity);
    }

    @PutMapping
    public OrderEntity updateOrder(@RequestBody OrderEntity orderEntity){
        return orderService.saveOrder(orderEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return "Deleted successfully";
    }
}
