package com.aca.homework.week18.website.facade.user.impl;

import com.aca.homework.week18.website.entity.User;
import com.aca.homework.week18.website.facade.user.core.UserMapper;
import com.aca.homework.week18.website.facade.user.core.UserSignUpResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class UserMapperImpl implements UserMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserMapperImpl.class);

    @Override
    public UserSignUpResponseDto mapper(User user) {
        LOGGER.info("Mapping a user - {} to user SignUp response dto", user);
        final UserSignUpResponseDto responseDto = new UserSignUpResponseDto(user.getFirstName(), user.getSecondName(), user.getUsername(), user.getPassword(), user.getSignUpDate());
        LOGGER.info("Successfully mapped a user - {} to user signUp response dto ,result - {}", user, responseDto);
        return responseDto;
    }
}