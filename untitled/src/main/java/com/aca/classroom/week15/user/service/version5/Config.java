package com.aca.classroom.week15.user.service.version5;

import com.aca.classroom.week15.user.service.version5.facade.UserMapper;
import com.aca.classroom.week15.user.service.version5.facade.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

    @Bean
    public UserMapper userMapper2() {
        return new UserMapperImpl();
    }

    @Bean
    public String stringBean() {
        return "MYPREFIX";
    }
}