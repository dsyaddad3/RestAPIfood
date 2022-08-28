package com.restfood.models.entitties;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_trans")
public class Transaction implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tran_no")
    private Integer transNo;
    @Column(name = "phone")
    private String phone;
    @Column(name = "reqtime")
    private LocalDate reqTime;

    public Transaction() {
        this.reqTime = LocalDate.now();
    }
    public Transaction(Transaction source) {
        this.phone = source.getPhone();
        this.reqTime = LocalDate.now();
    }
    public Transaction(String phone) {
        this.phone = phone;
        this.reqTime = LocalDate.now();
    }
    public void setReqTime(LocalDate reqTime) {
        this.reqTime = reqTime;
    }
    public Integer getTransNo() {
        return this.transNo;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }    
    public LocalDate getReqTime() {
        return this.reqTime;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Transaction)) {
            return false;
        }
        Transaction transaction = (Transaction) o;
        return Objects.equals(transNo, transaction.transNo) && Objects.equals(phone, transaction.phone) && Objects.equals(reqTime, transaction.reqTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transNo, phone, reqTime);
    }


    
}
