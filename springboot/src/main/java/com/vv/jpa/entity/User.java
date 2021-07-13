package com.vv.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_user")
@NamedQuery(name = "User.findByAge1",query = "select u from User u where u.age= ?1")
@NamedQueries({
        @NamedQuery(name = "User.findByAge2",query = "select u from User u where u.age= ?1"),
        @NamedQuery(name = "User.findMingZi",query = "select u from User u where u.name= :name")
})
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}




