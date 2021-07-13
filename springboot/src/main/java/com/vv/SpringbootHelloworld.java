package com.vv;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@MapperScan("com.vv.mybatisplus.mapper")
//@EnableCasClient
@EnableGlobalMethodSecurity(securedEnabled=true,prePostEnabled = true)
public class SpringbootHelloworld {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootHelloworld.class,args);
    }


}
