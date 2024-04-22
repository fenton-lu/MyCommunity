package com.nowcoder.community.entity;

import java.util.Date;

public class CWSUser {

    private int id; // 用户序号
    private String name; // 用户名称
    private String account; // 账户名
    private String password; // 密码
    private String userId;
    private String organizationId;
    private int level; // 用户级别
    private Date createdAt; // 创建时间

    public CWSUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public String toString() {
        return "CWSUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", userId='" + userId + '\'' +
                ", organizationId='" + organizationId + '\'' +
                ", level=" + level +
                ", createdAt=" + createdAt +
                '}';
    }
}
