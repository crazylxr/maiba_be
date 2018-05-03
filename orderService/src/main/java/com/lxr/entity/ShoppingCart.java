package com.lxr.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class ShoppingCart {

    @Id
    private String pkId;

    private String userId;

    private String goodsId;

    private int number;

    private boolean isPay;

    private double totalPrice;

    private  boolean isDelete;

    private Timestamp deleteTime;

    private Timestamp createTime;

    private Timestamp modifyTime;

    public ShoppingCart() {
    }

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isPay() {
        return isPay;
    }

    public void setPay(boolean pay) {
        isPay = pay;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Timestamp getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Timestamp deleteTime) {
        this.deleteTime = deleteTime;
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
        return "ShoppingCart{" +
                "pkId='" + pkId + '\'' +
                ", userId='" + userId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", number=" + number +
                ", isPay=" + isPay +
                ", totalPrice=" + totalPrice +
                ", isDelete=" + isDelete +
                ", deleteTime=" + deleteTime +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
