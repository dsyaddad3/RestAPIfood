package com.restfood.models.entitties;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_item")
public class Item implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_no")
    private Integer itemNo;
    @Column(name = "deskripsi")
    private String deskripsi;
    @Column(name = "price")
    private double price;

    public Item() {
    }
    public Item(Item source) {
        this.deskripsi = source.getDeskripsi();
        this.price = source.getPrice();
    }
    public Item(String desc, double price) {
        this.deskripsi = desc;
        this.price = price;
    }

    public Integer getItemNo() {
        return this.itemNo;
    }
    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }
    public String getDeskripsi() {
        return this.deskripsi;
    }
    public void setDesc(String desc) {
        this.deskripsi = desc;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Item)) {
            return false;
        }
        Item Item = (Item) o;
        return Objects.equals(itemNo, Item.itemNo) && Objects.equals(deskripsi, Item.deskripsi) && price == Item.price;
    }
    @Override
    public int hashCode() {
        return Objects.hash(itemNo, deskripsi, price);
    }


}
