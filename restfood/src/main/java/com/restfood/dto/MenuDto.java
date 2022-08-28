package com.restfood.dto;

import java.util.Objects;

public class MenuDto {
    private Integer codeMenu;
    private String name;
    private String price;

    public Integer getCodeMenu() {
        return this.codeMenu;
    }
    public void setCodeMenu(Integer codeMenu) {
        this.codeMenu = codeMenu;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MenuDto)) {
            return false;
        }
        MenuDto menuDto = (MenuDto) o;
        return Objects.equals(codeMenu, menuDto.codeMenu) && Objects.equals(name, menuDto.name) && Objects.equals(price, menuDto.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeMenu, name, price);
    }


}
