package com.aca.homework.week19.job.platform.mapper.impl;

import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.dto.UserDetailsDto;
import com.aca.homework.week19.job.platform.mapper.core.UserMapper;
import io.jsonwebtoken.lang.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserMapperImpl implements UserMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserMapperImpl.class);

    @Override
    public UserDetailsDto mapper(User user) {
        Assert.notNull(user, "the user param cannot be null");
        LOGGER.info("Mapping a user - {} to user Details dto", user);
        UserDetailsDto userDetailsDto = new UserDetailsDto
                (user.getFirstName(),
                        user.getSecondName(),
                        user.getUsername(),
                        user.getPassword(),
                        user.isOpenForJobOffers());
        LOGGER.info("Successfully mapped a user - {} to user Details dto ,result - {}", user, userDetailsDto);
        return userDetailsDto;

    }
}