package com.aca.homework.week19.job.platform.config;

import com.aca.homework.week19.job.platform.mapper.core.OrganizationMapper;
import com.aca.homework.week19.job.platform.mapper.core.UserMapper;
import com.aca.homework.week19.job.platform.mapper.impl.OrganizationMapperImpl;
import com.aca.homework.week19.job.platform.mapper.impl.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

    @Bean
    public OrganizationMapper organizationMapper() {
        return new OrganizationMapperImpl();
    }
}
