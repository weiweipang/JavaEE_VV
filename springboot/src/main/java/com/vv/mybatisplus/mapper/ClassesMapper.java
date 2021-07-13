package com.vv.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vv.mybatisplus.entity.Classes;
import com.vv.mybatisplus.entity.User;

public interface ClassesMapper extends BaseMapper<User> {

    /**
     * 按课程名查课程及对应的用户（多对一--多个课程属于一个用户）
     * @param classname
     * @return
     */
    Classes getUserByClass(String classname);

}
