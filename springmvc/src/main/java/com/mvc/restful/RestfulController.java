package com.mvc.restful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 演示restful api
 */
@Controller
public class RestfulController {
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    @ResponseBody
    public void getUser(@PathVariable("id") String id){
        System.out.println("查询"+id);
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public void updateUser(@PathVariable("id") String id){
        System.out.println("更新"+id);
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.POST)
    @ResponseBody
    public void insertUser(@PathVariable("id") String id){
        System.out.println("插入"+id);
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable("id") String id){
        System.out.println("删除"+id);
    }
}
