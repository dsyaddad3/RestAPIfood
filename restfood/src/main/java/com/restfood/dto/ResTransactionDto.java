package com.restfood.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class ResTransactionDto {
    private Integer transactionNo;
    private String phoneNumberCustomer;
    private LocalDate orderTime;
    private double totalPrice;
    private List<ResDetailTransactionDto> menus;


    public Integer getTransactionNo() {
        return this.transactionNo;
    }
    public void setTransactionNo(Integer transactionNo) {
        this.transactionNo = transactionNo;
    }
    public String getPhoneNumberCustomer() {
        return this.phoneNumberCustomer;
    }
    public void setPhoneNumberCustomer(String phoneNumberCustomer) {
        this.phoneNumberCustomer = phoneNumberCustomer;
    }
    public LocalDate getOrderTime() {
        return this.orderTime;
    }
    public void setOrderTime(LocalDate orderTime) {
        this.orderTime = orderTime;
    }
    public double getTotalPrice() {
        return this.totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public List<ResDetailTransactionDto> getMenus() {
        return this.menus;
    }
    public void setMenus(List<ResDetailTransactionDto> menus) {
        this.menus = menus;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ResTransactionDto)) {
            return false;
        }
        ResTransactionDto resTransactionDto = (ResTransactionDto) o;
        return Objects.equals(transactionNo, resTransactionDto.transactionNo) && Objects.equals(phoneNumberCustomer, resTransactionDto.phoneNumberCustomer) && Objects.equals(orderTime, resTransactionDto.orderTime) && totalPrice == resTransactionDto.totalPrice && Objects.equals(menus, resTransactionDto.menus);
    }
    @Override
    public int hashCode() {
        return Objects.hash(transactionNo, phoneNumberCustomer, orderTime, totalPrice, menus);
    }


}
