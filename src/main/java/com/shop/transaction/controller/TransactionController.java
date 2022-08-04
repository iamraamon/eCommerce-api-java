package com.shop.transaction.controller;

import com.shop.transaction.entity.TransactionEntity;
import com.shop.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<TransactionEntity> getOrderList(){
        return transactionService.getTransaction();
    }

    @PostMapping
    public TransactionEntity saveOrder(@RequestBody TransactionEntity transactionEntity){
        return transactionService.saveTransaction(transactionEntity);
    }

    @PutMapping
    public TransactionEntity updateOrder(@RequestBody TransactionEntity transactionEntity){
        return transactionService.saveTransaction(transactionEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id){
        transactionService.deleteTransaction(id);
        return "Deleted successfully";
    }
}
