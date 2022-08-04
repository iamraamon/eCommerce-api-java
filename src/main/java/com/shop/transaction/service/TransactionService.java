package com.shop.transaction.service;

import com.shop.transaction.entity.TransactionEntity;
import com.shop.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<TransactionEntity> getTransaction(){
        return transactionRepository.findAll();
    }

    public TransactionEntity saveTransaction(TransactionEntity transactionEntity){
        return transactionRepository.save(transactionEntity);
    }

    public void deleteTransaction(Long id){
        transactionRepository .deleteById(id);
    }
}
