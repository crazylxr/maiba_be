package com.lxr.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class OrderItem {

    @Id
    private String pkId;

    private String orderId;

    private String goodsId;

    private int number;

    private double totalPrice;

    private Timestamp createTime;

    private Timestamp modifyTime;

    public OrderItem() {
    }

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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
        return "OrderItem{" +
                "pkId='" + pkId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", number=" + number +
                ", totalPrice=" + totalPrice +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
