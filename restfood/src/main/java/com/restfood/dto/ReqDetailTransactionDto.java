package com.restfood.dto;

import java.util.Objects;

public class ReqDetailTransactionDto {
    private Integer codeMenu;
    private Integer qty;


    public Integer getCodeMenu() {
        return this.codeMenu;
    }
    public void setCodeMenu(Integer codeMenu) {
        this.codeMenu = codeMenu;
    }
    public Integer getQty() {
        return this.qty;
    }
    public void setQty(Integer qty) {
        this.qty = qty;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ReqDetailTransactionDto)) {
            return false;
        }
        ReqDetailTransactionDto reqDetailTransactionDto = (ReqDetailTransactionDto) o;
        return Objects.equals(codeMenu, reqDetailTransactionDto.codeMenu) && Objects.equals(qty, reqDetailTransactionDto.qty);
    }
    @Override
    public int hashCode() {
        return Objects.hash(codeMenu, qty);
    }

}
