package com.mvc.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public String sayHello(){
        return "hello";
    }
    @RequestMapping(value = "/path/{id}")
    public String sayHelloId(@PathVariable("id") String id1){
        System.out.println(id1);
        return "hello";
    }
}
