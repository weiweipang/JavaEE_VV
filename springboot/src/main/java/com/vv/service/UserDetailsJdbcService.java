package com.vv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsJdbcService implements UserDetailsService {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //模拟从数据库查询出来的用户信息
        List<GrantedAuthority> authority = AuthorityUtils.createAuthorityList("1admin1","ROLE_b");
//        List<GrantedAuthority> authority = AuthorityUtils.createAuthorityList("admin1","admin2");
        return new User("root",passwordEncoder.encode("root"),authority);
    }
}
