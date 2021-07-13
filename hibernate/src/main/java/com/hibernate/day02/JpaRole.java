package com.hibernate.day02;

import com.hibernate.day01.Customer;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "t_role")
public class JpaRole {
    @Id
    @GenericGenerator(name = "UUID", strategy = "uuid")
    @GeneratedValue(generator = "UUID")
    private String r_id;
    private String r_name;

    // mappedBy必须写不然会生成对于的表，将维护关系交给另一方
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "roleSet")
    private Set<JpaCustomer> customers = new HashSet<JpaCustomer>();

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

    public Set<JpaCustomer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<JpaCustomer> customers) {
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
