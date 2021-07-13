package com.hibernate.day01;

import java.util.HashSet;
import java.util.Set;

public class Customer {
    private String c_id;
    private String c_name;
    private String password;

    private Set<Role> roleSet = new HashSet<Role>();

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "c_id='" + c_id + '\'' +
                ", c_name='" + c_name + '\'' +
                ", password='" + password + '\'' +
                ", roleSet=" + roleSet +
                '}';
    }
}
