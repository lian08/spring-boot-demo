package com.agxx.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/v0.1/users").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()//关闭CSRF
            .formLogin()
                .loginPage("/v0.1/hellos/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // 在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }

}