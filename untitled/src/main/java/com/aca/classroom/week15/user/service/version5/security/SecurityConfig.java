package com.aca.classroom.week15.user.service.version5.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests().antMatchers(HttpMethod.GET,"/diplomas").hasAnyAuthority("STUDENT").anyRequest().authenticated();
        http.httpBasic();
    }
}