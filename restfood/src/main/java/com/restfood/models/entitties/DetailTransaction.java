package com.restfood.models.entitties;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_det_trans")
public class DetailTransaction implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "det_tran_no")
    private Integer detTransNo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tran_no", referencedColumnName = "tran_no")
    private Transaction transaction;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_no", referencedColumnName = "item_no")
    private Item item;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "sub_total")
    private double subtotal;


    public DetailTransaction() {
    }
    public DetailTransaction(DetailTransaction source) {
        this.detTransNo = source.getDetTransNo();
        this.transaction = new Transaction(source.getTransaction());
        this.item = new Item(source.getItem());
        this.qty = source.getQty();
        this.subtotal = source.getSubtotal();
    }
    public DetailTransaction(Transaction transaction, Item item, Integer qty, double subTotal) {
        this.transaction = new Transaction(transaction);
        this.item = new Item(item);
        this.qty = qty;
        this.subtotal = subTotal;
    }


    public Integer getDetTransNo() {
        return this.detTransNo;
    }
    public Transaction getTransaction() {
        return new Transaction(this.transaction);
    }
    public void setTransNo(Transaction transaction) {
        this.transaction = new Transaction(transaction);
    }
    public Item getItem() {
        return new Item(this.item);
    }
    public void setItemNo(Item item) {
        this.item = new Item(item);
    }
    public Integer getQty() {
        return this.qty;
    }
    public void setQty(Integer qty) {
        this.qty = qty;
    }
    public double getSubtotal() {
        return this.subtotal;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DetailTransaction)) {
            return false;
        }
        DetailTransaction detailTransaction = (DetailTransaction) o;
        return Objects.equals(detTransNo, detailTransaction.detTransNo) && Objects.equals(transaction, detailTransaction.transaction) && Objects.equals(item, detailTransaction.item) && Objects.equals(qty, detailTransaction.qty) && subtotal == detailTransaction.subtotal;
    }
    @Override
    public int hashCode() {
        return Objects.hash(detTransNo, transaction, item, qty, subtotal);
    }


}
