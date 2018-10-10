package com.java.mh.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication()
                .withUser("zheng")
                .password(new BCryptPasswordEncoder().encode("xq123456"))
                .roles("ADMIN");*/

        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("cxh").password("cxh").roles("ADMIN");

    }



    /**
     * 请求授权
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable().headers().disable()
                .authorizeRequests().antMatchers("/","/static/**").permitAll()  //不需要身份认证的请求地址
                .anyRequest().authenticated()  //其它所有路径需要身份认证
                .and()
                .formLogin()
                .loginPage("/login") //指定登录请求地址
                .defaultSuccessUrl("/admin")  //登录成功后的默认跳转页面
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .permitAll();
    }
}
