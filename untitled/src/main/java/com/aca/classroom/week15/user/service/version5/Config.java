package com.aca.classroom.week15.user.service.version5;

import com.aca.classroom.week15.user.service.version5.facade.UserMapper;
import com.aca.classroom.week15.user.service.version5.facade.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config {

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

    /*
    @Bean
    public UserMapper userMapper2() {
        return new UserMapperImpl();
    }
     */
    @Bean
    public String stringBean() {
        return "MYPREFIX";
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}