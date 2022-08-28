package com.restfood.models.repos;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.restfood.models.entitties.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction,Integer>{

    @Modifying
    @Query(value = "insert into tb_trans (cust_no, reqtime) values (?, ?)",nativeQuery = true)
	public Integer saveNewTran(Long custNo, LocalDate reqtime);
}
