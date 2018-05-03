package com.lxr.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class Orders {

    @Id
    private String pkId;

    private String orderId;

    private String userId;

    private double totalPrice;

    private String addressId;

    private String remark;

    private  int state;

    private Timestamp deliveryStartTime;

    private Timestamp paymentTime;

    private Timestamp deliveryEndTime;

    private Timestamp createTime;

    private Timestamp modifyTime;

    public Orders() {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Timestamp getDeliveryStartTime() {
        return deliveryStartTime;
    }

    public void setDeliveryStartTime(Timestamp deliveryStartTime) {
        this.deliveryStartTime = deliveryStartTime;
    }

    public Timestamp getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Timestamp getDeliveryEndTime() {
        return deliveryEndTime;
    }

    public void setDeliveryEndTime(Timestamp deliveryEndTime) {
        this.deliveryEndTime = deliveryEndTime;
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
        return "Orders{" +
                "pkId='" + pkId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", totalPrice=" + totalPrice +
                ", addressId='" + addressId + '\'' +
                ", remark='" + remark + '\'' +
                ", state=" + state +
                ", deliveryStartTime=" + deliveryStartTime +
                ", paymentTime=" + paymentTime +
                ", deliveryEndTime=" + deliveryEndTime +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
