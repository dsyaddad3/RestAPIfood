package com.restfood.dto;

import java.util.List;
import java.util.Objects;

public class ReqTransactionDto {
    private String numberPhone;
    private List<ReqDetailTransactionDto> orders;


    public String getNumberPhone() {
        return this.numberPhone;
    }
    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
    public List<ReqDetailTransactionDto> getOrders() {
        return this.orders;
    }
    public void setOrders(List<ReqDetailTransactionDto> orders) {
        this.orders = orders;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ReqTransactionDto)) {
            return false;
        }
        ReqTransactionDto reqTransactionDto = (ReqTransactionDto) o;
        return Objects.equals(numberPhone, reqTransactionDto.numberPhone) && Objects.equals(orders, reqTransactionDto.orders);
    }
    @Override
    public int hashCode() {
        return Objects.hash(numberPhone, orders);
    }

}
