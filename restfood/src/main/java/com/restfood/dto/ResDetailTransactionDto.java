package com.restfood.dto;

import java.util.Objects;

public class ResDetailTransactionDto {
    private String itemName;
    private double itemPrice;
    private Integer itemQty;
    private double  subTotalPrice;

    public String getItemName() {
        return this.itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public double getItemPrice() {
        return this.itemPrice;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    public Integer getItemQty() {
        return this.itemQty;
    }
    public void setItemQty(Integer itemQty) {
        this.itemQty = itemQty;
    }
    public double getSubTotalPrice() {
        return this.subTotalPrice;
    }
    public void setSubTotalPrice(double subTotalPrice) {
        this.subTotalPrice = subTotalPrice;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ResDetailTransactionDto)) {
            return false;
        }
        ResDetailTransactionDto detailTransactiondto = (ResDetailTransactionDto) o;
        return Objects.equals(itemName, detailTransactiondto.itemName) && itemPrice == detailTransactiondto.itemPrice && Objects.equals(itemQty, detailTransactiondto.itemQty) && subTotalPrice == detailTransactiondto.subTotalPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, itemPrice, itemQty, subTotalPrice);
    }

}
