package com.restfood.models.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restfood.models.entitties.DetailTransaction;

public interface DetailTransactionRepo extends JpaRepository<DetailTransaction,Integer> {
    //NATIVE QUERY
    @Modifying
    @Query(value = "select b.deskripsi, b.price, a.qty, a.sub_total from tb_det_trans a, tb_item b where a.item_no = b.item_no and a.tran_no = :transactionNo",nativeQuery = true)
	public List<Object[]> findOneTranByTranNo(@Param("transactionNo") int transactionNo);

    @Modifying
    @Query(value = "insert into tb_det_trans (item_no, qty, sub_total, tran_no) values (?, ?, ?, ?)",nativeQuery = true)
	public void saveNewDet(Integer itemNo, Integer qty, double subTotal, Integer transNo);
}
