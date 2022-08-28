package com.restfood.services;

import java.util.List;

import com.restfood.dto.ReqTransactionDto;
import com.restfood.dto.ResDetailTransactionDto;
import com.restfood.dto.ResTransactionDto;
import com.restfood.models.entitties.Transaction;


public interface TransactionService {
    public Transaction saveTransaction(Transaction transaction);
    public Transaction findOneTransaction(Integer tranNo);
    public ResTransactionDto order(ReqTransactionDto order);
    public List<ResDetailTransactionDto> findOneDetailTransaction(Integer tranNo);
    
}
