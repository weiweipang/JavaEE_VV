package com.hibernate.day01;

import java.util.HashSet;
import java.util.Set;

public class Role {
    private String r_id;
    private String r_name;

    private Set<Customer> customers = new HashSet<Customer>();

    public String getR_id() {
        return r_id;
    }

    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Role{" +
                "r_id='" + r_id + '\'' +
                ", r_name='" + r_name + '\'' +
                '}';
    }
}
