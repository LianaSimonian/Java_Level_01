package com.aca.homework.week18.website.facade.user.impl;

import com.aca.homework.week18.website.entity.User;
import com.aca.homework.week18.website.facade.user.core.UserFacade;
import com.aca.homework.week18.website.facade.user.core.UserMapper;
import com.aca.homework.week18.website.facade.user.core.UserSignUpRequestDto;
import com.aca.homework.week18.website.facade.user.core.UserSignUpResponseDto;
import com.aca.homework.week18.website.service.core.CreateUserParams;
import com.aca.homework.week18.website.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

public class UserFacadeImpl implements UserFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFacadeImpl.class);

    private final UserService userService;
    private final UserMapper userMapper;

    public UserFacadeImpl(UserService userService, UserMapper userMapper) {
        Assert.notNull(userService, "The provided userService should not be null");
        Assert.notNull(userMapper, "The provided userMapper should not be null");
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public UserSignUpResponseDto signUp(UserSignUpRequestDto dto) {
        Assert.notNull(dto, "user sign up request dto param should not be null");
        LOGGER.info("signing up  the user according to the provided request - {}", dto);
        String userName = dto.getUsername();
        String password = dto.getPassword();
        Optional<User> userOptional = userService.findByUsernameAndPassword(userName, password);
        if (userOptional.isPresent()) {
            return new UserSignUpResponseDto(List.of(String.format("user with username %s and password %s already exists", userName, password)));
        }

        final User user = userService.create(
                new CreateUserParams(
                        dto.getFirstName(),
                        dto.getSecondName(),
                        userName,
                        password
                )
        );

        final UserSignUpResponseDto responseDto = userMapper.mapper(user);
        LOGGER.info(" Successfully  signup user according to the provided request - {}, responseDto - {}", dto, responseDto);
        return responseDto;
    }
}