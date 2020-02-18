package cn.pww.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("hello")
    public String helloThymeleaf(Map<String,Object> map){
        map.put("hello","测试");
        map.put("hello1","<h4>是否转义</h4>");
        map.put("users",Arrays.asList("tom","jerry","kitty"));
        return "success";
    }
    @RequestMapping("/")
    public String login(){
        return "login";
    }



}
