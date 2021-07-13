package com.mvc.param;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
