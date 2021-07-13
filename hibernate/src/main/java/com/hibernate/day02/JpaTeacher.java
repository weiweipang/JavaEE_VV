package com.hibernate.day02;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "t_teacher")
public class JpaTeacher {
    @Id
    @GenericGenerator(name = "UUID", strategy = "uuid")
    @GeneratedValue(generator = "UUID")
    private String t_id;
    private String t_name;
    private int t_age;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<JpaStudent> jpaStudents = new HashSet<JpaStudent>();

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public int getT_age() {
        return t_age;
    }

    public void setT_age(int t_age) {
        this.t_age = t_age;
    }

    public Set<JpaStudent> getJpaStudents() {
        return jpaStudents;
    }

    public void setJpaStudents(Set<JpaStudent> jpaStudents) {
        this.jpaStudents = jpaStudents;
    }

    @Override
    public String toString() {
        return "JpaTeacher{" +
                "t_id='" + t_id + '\'' +
                ", t_name='" + t_name + '\'' +
                ", t_age=" + t_age +
//                ", jpaStudents=" + jpaStudents +
                '}';
    }
}
