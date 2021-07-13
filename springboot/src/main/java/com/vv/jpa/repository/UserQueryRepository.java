package com.vv.jpa.repository;

import com.vv.jpa.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserQueryRepository extends Repository<User,Long> {

    @Query("select u from User u where u.name = ?1")
    User findByEmailAddress(String name);

    User findByAge1(Integer age);

    User findByAge2(Integer age);

    //可以用@Param 指定name来和User实体类上的：name参数形成绑定
    User findMingZi(@Param("name") String name1);

    //jpql模糊查询
//    @Query("select u from User u where u.name like %?1")
//    List<User> findLikeByName(String name);
    @Query("select u from User u where u.name like ?1%")
    List<User> findLikeByName(String name);

    //用原生sql查询
    @Query(value = "select * from t_user u where u.name = ?1",nativeQuery = true)
    User findByNativeName(String name);
}
