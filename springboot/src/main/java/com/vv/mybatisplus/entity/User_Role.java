package com.vv.mybatisplus.entity;

import javax.persistence.Table;

@Table(name = "t_user_role")
public class User_Role {
    private String id;
    private String uid;
    private String rid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "User_Role{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", rid='" + rid + '\'' +
                '}';
    }
}
