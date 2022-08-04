package com.shop.order.controller;

import com.shop.order.entity.Order_ItemEntity;
import com.shop.order.service.Order_ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {

    @Autowired
    private Order_ItemService orderItemService;

    @GetMapping
    public List<Order_ItemEntity> getOrderList(){
        return orderItemService.getOrderItem();
    }

    @PostMapping
    public Order_ItemEntity saveOrder(@RequestBody Order_ItemEntity orderItemEntity){
        return orderItemService.saveOrderItem(orderItemEntity);
    }

    @PutMapping
    public Order_ItemEntity updateOrder(@RequestBody Order_ItemEntity orderItemEntity){
        return orderItemService.saveOrderItem(orderItemEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id){
        orderItemService.deleteOrderItem(id);
        return "Deleted successfully";
    }
}
