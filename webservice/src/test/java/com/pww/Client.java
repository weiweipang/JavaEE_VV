package com.pww;

import com.pww.service.HelloService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class Client {
    public static void main(String[] args) {
        //创建接口代理工厂
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        //设置服务端地址
        factory.setAddress("http://localhost:9999/ws/hello");
        //设置接口类型
        factory.setServiceClass(HelloService.class);
        //创建接口代理对象
        HelloService helloService = factory.create(HelloService.class);
        //远程访问服务端接口
        String hello_service = helloService.sayHello("hello Service");
        System.out.println(hello_service);

    }
}
