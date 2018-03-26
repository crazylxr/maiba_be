package com.lxr.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Comment {

    @Id
    private String pkId;

    private String userId;

    private String content;

    private Integer star;

    private Timestamp createTime;

    private Timestamp modifyTime;

    public Comment() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
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
        return "Comment{" +
                "pkId='" + pkId + '\'' +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", star=" + star +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
