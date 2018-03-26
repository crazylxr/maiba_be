package com.lxr.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Classification {

    @Id
    private String pkId;

    private String name;

    private String parentId;

    private int level;

    private Timestamp createTime;

    private Timestamp modifyTime;

    public Classification() {
    }

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
        return "Classification{" +
                "pkId='" + pkId + '\'' +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                ", level=" + level +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
