package com.vv.jpa.repository;

import com.vv.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    long countByname(String lastname);

}
