package com.vv.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

@TableName("t_user")
public class User {
    private Integer id;
    private String name;
    private Integer age;
    //测试一对多
    private List<Classes> classes;
    //测试多对多
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classes=" + classes +
                ", roles=" + roles +
                '}';
    }
}




