package com.lxr.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Goods {

    @Id
    private String pkId;

    private String goodsId;

    private String lassificationId;

    private String name;

    private String description;

    private int inventory;

    private double price;

    private double discountPrice;

    private double discount;

    private Integer volume;

    private boolean isShelf;

    private Timestamp createTime;

    private Timestamp modifyTime;

    public Goods() {
    }

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getLassificationId() {
        return lassificationId;
    }

    public void setLassificationId(String lassificationId) {
        this.lassificationId = lassificationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public boolean isShelf() {
        return isShelf;
    }

    public void setShelf(boolean shelf) {
        isShelf = shelf;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "pkId='" + pkId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", lassificationId='" + lassificationId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", inventory=" + inventory +
                ", price=" + price +
                ", discountPrice=" + discountPrice +
                ", discount=" + discount +
                ", volume=" + volume +
                ", isShelf=" + isShelf +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
