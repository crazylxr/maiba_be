package com.lxr.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class GoodsImage {

    @Id
    private String pkId;

    private String goodsId;

    private String resourcesId;

    private int type;

    private Integer orderNumber;

    private Timestamp createTime;

    private Timestamp modifyTime;

    public GoodsImage() {
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

    public String getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(String resourcesId) {
        this.resourcesId = resourcesId;
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
                "pkId='" + pkId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", resourcesId='" + resourcesId + '\'' +
                ", type=" + type +
                ", orderNumber=" + orderNumber +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
