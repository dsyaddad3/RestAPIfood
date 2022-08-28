package com.restfood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restfood.dto.ReqTransactionDto;
import com.restfood.dto.ResTransactionDto;
import com.restfood.dto.ValidationDto;
import com.restfood.services.TransactionService;

@RestController
@RequestMapping("/order")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    
    @PostMapping("/menu")
    public ResponseEntity<Object> orderMenu(@RequestBody ReqTransactionDto reqTransactionDto){
        ResTransactionDto check = transactionService.order(reqTransactionDto); 
        if(check == null){
            ValidationDto empty = new ValidationDto();
            empty.setStatus(false);
            empty.setMessages("Menu Kosong");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(empty);
        }
        return ResponseEntity.ok().body(check);
    }
    
}
