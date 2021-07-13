package com.vv.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class WebSecurityJdbcConfig extends WebSecurityConfigurerAdapter {

    //此接口负责获得数据库中的用户信息
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    /**
     * 这里可以自定义登录页面，登录成功后的页面，以及那些路径不拦截等
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //无权限的自定义页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");

        //基本配置
        http
            .formLogin() //指定支持基于表单的身份验证。如果未指定FormLoginConfigurer#loginPage(String)，则将生成默认登录页面
            .loginPage("/login.html") //指定登录页路径
            .loginProcessingUrl("/user/login")//登录页表单提交路径（和表单中的action对应）
            .defaultSuccessUrl("/index").permitAll()//登录成功后跳转页面
            .and().csrf().disable()
            .authorizeRequests() //允许基于使用HttpServletRequest限制访问
            .antMatchers("/hello","/test").permitAll() //那些路径不拦截
            .antMatchers("/admin").hasAuthority("admin") //有admin单个权限才可以访问
//            .antMatchers("/admins").hasAnyAuthority("admin1","admin2") //有多个权限才可以访问
//            .antMatchers("/admins").hasRole("admin") //有admin单个角色才可以访问
                //hasAnyRole使用的时候在UserDetailsService中需要加ROLE_前缀
//            .antMatchers("/admins").hasAnyRole("admin1","admin2")
            .anyRequest().authenticated(); //除了放行的路径都拦截

        //开启记住我功能
        http.rememberMe().tokenRepository(persistentTokenRepository()).userDetailsService(userDetailsService);

        //注销配置 再登录成功的页面，添加注销按钮，按钮点击路径设置/logout即可
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/index").permitAll();

    }

    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        // 赋值数据源
        jdbcTokenRepository.setDataSource(dataSource);
        // 自动创建表,第一次执行会创建，以后要执行就要删除掉！
//        jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }
}
