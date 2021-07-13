package com.vv.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

@TableName("t_role")
public class Role {
    private Integer id;
    private String r_name;

    private List<User> users;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", r_name='" + r_name + '\'' +
                ", users=" + users +
                '}';
    }
}




