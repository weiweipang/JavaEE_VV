package com.vv.consumer;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Spring整合ActiveMQ消费消息
 */
public class SpringConsumerTest {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-consumer.xml");
        System.in.read();
    }

}
