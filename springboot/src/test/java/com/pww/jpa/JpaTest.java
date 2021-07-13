package com.pww.jpa;

import com.alibaba.fastjson.JSON;
import com.vv.SpringbootHelloworld;
import com.vv.jpa.entity.User;
import com.vv.jpa.repository.UserQueryRepository;
import com.vv.jpa.repository.UserRepository;
import com.vv.mail.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest(classes = SpringbootHelloworld.class)
@RunWith(SpringRunner.class)
public class JpaTest {
    private static final Logger logger = LoggerFactory.getLogger(JpaTest.class);
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserQueryRepository userQueryRepository;

    @Autowired
    MailService mailService;

    @Test
    public void addUser(){
        User user = new User();
        user.setName("张三");
        user.setAge(22);
        userRepository.save(user);
    }

    @Test
    public void countUser(){
        //派生基数查询：spring data jpa会根据方法名称去查询对应字段
        long users = userRepository.countByname("张三");
        logger.warn("用户数量",users);
    }

    //测试spring data jpa分页查询
    @Test
    public void getUsersByPage(){

        Page<User> users = userRepository.findAll(PageRequest.of(0, 10));
        //加入{}才能解析出对象打印
        logger.warn("用户分页:{}",users.getContent());
        logger.info(JSON.toJSONString(users));
    }

    //测试通过@Query直接写jpql查询
    @Test
    public void testQuery(){
        User user = userQueryRepository.findByEmailAddress("张三");
        logger.warn("通过@Query查询：{}",user);
    }


    //测试通过@NamedQuery写jpql查询
    @Test
    public void testNamedQuery(){
        User user1 = userQueryRepository.findByAge1(22);
        logger.warn("通过@NamedQuery查询1：{}",user1);
        User user2 = userQueryRepository.findByAge2(22);
        logger.warn("通过@NamedQuery查询2：{}",user2);
        User user3 = userQueryRepository.findMingZi("张三");
        logger.warn("通过@NamedQuery查询3：{}",user3);
    }

    //测试jpql模糊查询
    @Test
    public void testLikeQuery(){
        List<User> users = userQueryRepository.findLikeByName("张");
        logger.warn("通过@Query查询：{}",users);
    }
    //测试NativeQuery
    @Test
    public void testNativeQuery(){
        User user = userQueryRepository.findByNativeName("张三");
        logger.warn("通过@QueryNativeQuery查询：{}",user);
    }

    @Test
    public void sendMail(){
        mailService.send();
    }
}





