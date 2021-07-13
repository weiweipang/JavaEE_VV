package com.vv.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vv.mybatisplus.entity.User;

public interface UserMapper extends BaseMapper<User> {
    User getUserByName(String name);

    /**
     * 按用户名查用户和对应的课程（一对多--一个用户有多个课程）
     * @param username
     * @return
     */
    User getUserClass(String username);
    /**
     * 按课程名查课程及对应的用户（多对一--多个课程属于一个用户）
     * @param classname
     * @return
     */

    /**
     * 多对多根据用户名查询用户及其角色
     * @param username
     * @return
     */
    User getUserWithRole(String username);

}
