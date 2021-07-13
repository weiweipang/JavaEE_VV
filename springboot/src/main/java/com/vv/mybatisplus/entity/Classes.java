package com.vv.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_class")
public class Classes {
    private Integer id;
    private String c_name;
    private String u_id;
    //测试多对一
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", c_name='" + c_name + '\'' +
                ", u_id='" + u_id + '\'' +
                ", user=" + user +
                '}';
    }
}




