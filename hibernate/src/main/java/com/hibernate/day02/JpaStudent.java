package com.hibernate.day02;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="t_student")
public class JpaStudent {

    @Id
    @GenericGenerator(name = "UUID", strategy = "uuid")
    @GeneratedValue(generator = "UUID")
    @Column(name = "s_id")
    private String id;
    private String name;
    private int age;
    private int gender;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ss_id")
    private JpaTeacher jpaTeacher;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public JpaTeacher getJpaTeacher() {
        return jpaTeacher;
    }

    public void setJpaTeacher(JpaTeacher jpaTeacher) {
        this.jpaTeacher = jpaTeacher;
    }


    @Override
    public String toString() {
        return "JpaStudent{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
