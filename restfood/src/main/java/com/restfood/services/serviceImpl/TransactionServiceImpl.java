package com.restfood.services.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restfood.dto.ReqTransactionDto;
import com.restfood.dto.ResDetailTransactionDto;
import com.restfood.dto.ResTransactionDto;
import com.restfood.models.entitties.Transaction;
import com.restfood.models.repos.DetailTransactionRepo;
import com.restfood.models.repos.TransactionRepo;
import com.restfood.services.ItemService;
import com.restfood.services.TransactionService;


@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{
    //IOC
    @Autowired
    private TransactionRepo transactionRepo;
    @Autowired
    private DetailTransactionRepo detTranRepo;
    @Autowired
    private ItemService itemService;

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        if(transaction == null){
            return null;
        }
        return transactionRepo.save(transaction);
    }

    @Override
    public Transaction findOneTransaction(Integer tranNo) {
        Optional<Transaction> tran = transactionRepo.findById(tranNo);
        if(!tran.isPresent()){
            return null;
        }
        return transactionRepo.findById(tranNo).get();
    }

    static Transaction transaction = new Transaction();

    @Override
    public ResTransactionDto order(ReqTransactionDto order) {
        ResTransactionDto responeOrder = new ResTransactionDto();
        List<ResDetailTransactionDto> menus = new ArrayList<ResDetailTransactionDto>();
        transaction = saveTransaction(new Transaction(order.getNumberPhone()));
        //STREAM
        double total = order.getOrders().stream().mapToDouble(a -> (itemService.findOne(a.getCodeMenu()).getPrice() * a.getQty())).sum();
        order.getOrders().stream().forEach(detailtransactionDto ->{
            ResDetailTransactionDto responeDetail = new ResDetailTransactionDto();
            detTranRepo.saveNewDet(detailtransactionDto.getCodeMenu(), detailtransactionDto.getQty(), (itemService.findOne(detailtransactionDto.getCodeMenu()).getPrice() * detailtransactionDto.getQty()), transaction.getTransNo());
            responeDetail.setItemName(itemService.findOne(detailtransactionDto.getCodeMenu()).getDeskripsi());
            responeDetail.setItemPrice(itemService.findOne(detailtransactionDto.getCodeMenu()).getPrice());
            responeDetail.setItemQty(detailtransactionDto.getQty());
            responeDetail.setSubTotalPrice((itemService.findOne(detailtransactionDto.getCodeMenu()).getPrice() * detailtransactionDto.getQty()));
            menus.add(responeDetail);
        });
        responeOrder.setPhoneNumberCustomer(order.getNumberPhone());
        responeOrder.setOrderTime(transaction.getReqTime());
        responeOrder.setTransactionNo(transaction.getTransNo());
        responeOrder.setTotalPrice(total);
        responeOrder.setMenus(menus);
        return responeOrder;
    }


    @Override
    public List<ResDetailTransactionDto> findOneDetailTransaction(Integer tranNo) {
        List<Object[]> findOneTransaction = detTranRepo.findOneTranByTranNo(tranNo);
        List<ResDetailTransactionDto> allDetail = new ArrayList<ResDetailTransactionDto>();
        if(findOneTransaction.isEmpty()){
            return null;
        } 
        for (Object[] objects : findOneTransaction) {
            ResDetailTransactionDto detail = new ResDetailTransactionDto();
            String deskripsi = objects[0].toString();
            double price = Double.parseDouble(objects[1].toString());
            Integer qty = Integer.parseInt(objects[2].toString());
            double subtotal = Double.parseDouble(objects[3].toString());
            detail.setItemName(deskripsi);
            detail.setItemPrice(price);
            detail.setItemQty(qty);
            detail.setSubTotalPrice(subtotal);
            allDetail.add(detail);
        }
        return allDetail;
    }
    
}
