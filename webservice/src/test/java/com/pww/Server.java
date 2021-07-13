package com.pww;

import com.pww.service.HelloServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server {
    public static void main(String[] args) {
        //创建发布服务的工厂
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        //设置服务发布地址
        factory.setAddress("http://localhost:9999/ws/hello");
        //是指服务实现
        factory.setServiceBean(new HelloServiceImpl());
        //发布
        factory.create();
    }
}
