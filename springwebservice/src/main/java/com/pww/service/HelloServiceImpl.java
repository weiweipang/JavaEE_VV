package com.pww.service;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String hello) {
        return "hello client";
    }
}
