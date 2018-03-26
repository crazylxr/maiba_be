package com.lxr.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class CommentImage {

    @Id
    private String pkId;

    private String commentId;

    private String resourcesId;

    private Integer orderNumber;

    private Timestamp createTime;

    private Timestamp modifyTime;

    public CommentImage() {
    }

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(String resourcesId) {
        this.resourcesId = resourcesId;
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
        return "CommentImage{" +
                "pkId='" + pkId + '\'' +
                ", commentId='" + commentId + '\'' +
                ", resourcesId='" + resourcesId + '\'' +
                ", orderNumber=" + orderNumber +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
