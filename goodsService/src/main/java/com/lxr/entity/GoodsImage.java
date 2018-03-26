package com.lxr.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class GoodsImage {

    @Id
    private String pk_id;

    private String goods_id;

    private String resources_id;

    private int type;

    private Integer orderNumber;

    private Timestamp createTime;

    private Timestamp modifyTime;

    public GoodsImage() {
    }

    public String getPk_id() {
        return pk_id;
    }

    public void setPk_id(String pk_id) {
        this.pk_id = pk_id;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getResources_id() {
        return resources_id;
    }

    public void setResources_id(String resources_id) {
        this.resources_id = resources_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
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
        return "GoodsImage{" +
                "pk_id='" + pk_id + '\'' +
                ", goods_id='" + goods_id + '\'' +
                ", resources_id='" + resources_id + '\'' +
                ", type=" + type +
                ", orderNumber=" + orderNumber +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
