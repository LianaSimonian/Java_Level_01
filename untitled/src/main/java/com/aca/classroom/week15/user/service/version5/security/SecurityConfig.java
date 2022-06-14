package com.aca.classroom.week15.user.service.version5.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests().antMatchers("/diplomas").hasAnyAuthority("STUDENT").anyRequest().authenticated();
        http.httpBasic();
    }
}
