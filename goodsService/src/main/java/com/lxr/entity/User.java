package com.lxr.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class User {

    @Id
    private String pkId;

    private String username;

    private String password;

    private String nickname;

    private String name;

    private Date birthday;

    private boolean gender;

    private String tel;

    private boolean userType;

    private boolean state;

    private String defaultDeliveryId;

    private Timestamp createTime;

    private Timestamp modifyTime;

    public User() {
    }

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean isUserType() {
        return userType;
    }

    public void setUserType(boolean userType) {
        this.userType = userType;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getDefaultDeliveryId() {
        return defaultDeliveryId;
    }

    public void setDefaultDeliveryId(String defaultDeliveryId) {
        this.defaultDeliveryId = defaultDeliveryId;
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
        return "User{" +
                "pkId='" + pkId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", tel='" + tel + '\'' +
                ", userType=" + userType +
                ", state=" + state +
                ", defaultDeliveryId='" + defaultDeliveryId + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
