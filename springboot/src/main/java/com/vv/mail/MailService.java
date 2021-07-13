package com.vv.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private JavaMailSender jsm;
    public String send(){
        //建立邮箱消息
        SimpleMailMessage message = new SimpleMailMessage();
        //发送者
        message.setFrom("wwpang@163.com");
        //接收者
        message.setTo("245376511@qq.com");
        //发送标题
        message.setSubject("测试");
        //发送内容
        message.setText("测试数据");
        jsm.send(message);
        return "1";
    }
}
