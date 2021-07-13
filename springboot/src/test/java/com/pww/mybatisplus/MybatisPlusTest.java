package com.pww.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vv.SpringbootHelloworld;
import com.vv.mybatisplus.entity.Classes;
import com.vv.mybatisplus.entity.User;
import com.vv.mybatisplus.mapper.ClassesMapper;
import com.vv.mybatisplus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootHelloworld.class)
public class MybatisPlusTest {
    @Autowired
    UserMapper userMapper;

    @Autowired
    ClassesMapper classesMapper;

    //============================================mapper的CRUD================================================
    //测试selectById
    @Test
    public void findUserById(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    //测试insert
    @Test
    public void add(){
        User user = new User();
        user.setName("李四");
        user.setAge(29);
        userMapper.insert(user);
    }
    //测试selectOne
    @Test
    public void selectOne(){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("name", "李四"));
        System.out.println(user);
    }


    // //==================================通过xml绑定接口查询（mybatis那套）===============================
    @Test
    public void getUserByName(){
        User user = userMapper.getUserByName("张三");
        System.out.println(user);
    }


    /**
     * 一对多
     */
    @Test
    public void getUserClass(){
        User user = userMapper.getUserClass("张三");
        System.out.println(user);
    }
    /**
     * 多对一
     */
    @Test
    public void getUserByClass(){
        Classes classes = classesMapper.getUserByClass("数学");
        System.out.println(classes);
    }
    /**
     * 多对多
     */
    @Test
    public void getUserWithRole(){
        User user = userMapper.getUserWithRole("张三");
        System.out.println(user);
    }



}
