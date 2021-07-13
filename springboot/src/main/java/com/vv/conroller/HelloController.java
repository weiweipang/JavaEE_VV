package com.vv.conroller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("hello")
    public String helloSpringboot(){
        return "你好springboot！";
    }

    @RequestMapping("index")
    public String index(){
        return "你好 index！";
    }

    /**
     * 用@secured测试权限,UserDetailsJdbcService中有相关权限才可以访问
     * @return
     */
    @Secured({"ROLE_a","ROLE_b"})
    @RequestMapping("securedTest")
    public String securedTest(){
        return "你好 securedTest！";
    }
    /**
     * 用@PreAuthorize测试权限,UserDetailsJdbcService中有相关权限才可以访问
     * @return
     */
    @RequestMapping("preAuthorize")
    @PreAuthorize("hasAnyAuthority('ROLE_b')")
    public String preAuthorizeTest(){
        return "你好 preAuthorizeTest！";
    }


}
