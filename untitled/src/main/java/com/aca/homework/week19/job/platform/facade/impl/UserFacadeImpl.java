package com.aca.homework.week19.job.platform.facade.impl;

import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.dto.UserDetailsDto;
import com.aca.homework.week19.job.platform.facade.core.UserFacade;
import com.aca.homework.week19.job.platform.mapper.core.UserMapper;
import com.aca.homework.week19.job.platform.dto.UserSignUpRequestDto;
import com.aca.homework.week19.job.platform.service.core.CreateUserParams;
import com.aca.homework.week19.job.platform.service.core.UpdateUserParams;
import com.aca.homework.week19.job.platform.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Component
public class UserFacadeImpl implements UserFacade {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserFacadeImpl.class);

    private final UserService userService;
    private final UserMapper userMapper;

    public UserFacadeImpl(UserService userService, UserMapper userMapper) {
        Assert.notNull(userService, "The provided userService should not be null");
        Assert.notNull(userMapper, "The provided userMapper should not be null");
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public UserDetailsDto signUp(UserSignUpRequestDto dto) {
        Assert.notNull(dto, "the user signUp request dto param should not be null");
        LOGGER.info("signing up the user  according to the provided request - {}", dto);
        String username = dto.getUsername();
        String password = dto.getPassword();
        Optional<User> userOptional = userService.findByUsernameAndPassword(username, password);
        if (userOptional.isPresent()) {
            return new UserDetailsDto(List.of(String.format("user with username %s and password %s already exists", username, password)));
        }

        final User user = userService.create(new CreateUserParams(
                dto.getFirstName(),
                dto.getSecondName(),
                dto.getUsername(),
                dto.getPassword(),
                false
        ));
        UserDetailsDto userDetailsDto = userMapper.mapper(user);
        LOGGER.info(" Successfully signed up user according to the provided request - {}, userDetailsDto - {}", dto, userDetailsDto);
        return userDetailsDto;
    }

    @Override
    public UserDetailsDto getUserDetails(Long userId) {
        Assert.notNull(userId, "the userId cannot be null");
        LOGGER.info("getting the user details having id - {}", userId);
        Optional<User> userOptional = userService.findById(userId);
        if (userOptional.isEmpty()) {
            return new UserDetailsDto(List.of(String.format("user with id %d not found", userId)));
        }
        User user = userOptional.get();
        UserDetailsDto userDetailsDto = userMapper.mapper(user);
        LOGGER.info("Successfully got the user details having id - {},result - {}", userId, userDetailsDto);
        return userDetailsDto;
    }

    @Override
    public UserDetailsDto openToWork(Long userId) {
        Assert.notNull(userId, "the userId cannot be null");
        LOGGER.info("marking a user with id - {} as open for job offers", userId);
        Optional<User> userOptional = userService.findById(userId);
        if (userOptional.isEmpty()) {
            return new UserDetailsDto(List.of(String.format("user with id %d not found", userId)));
        }
        User user = userOptional.get();
        if (user.isOpenForJobOffers()) {
            return new UserDetailsDto((List.of(String.format("user with id %d already is open for job offers", userId))));
        }
        User updatedUser = userService.update(new UpdateUserParams(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                true));

        UserDetailsDto userDetailsDto = userMapper.mapper(updatedUser);
        LOGGER.info("Successfully marked a user with id - {} as open for job offers, userDetailsDto - {}", userDetailsDto);
        return userDetailsDto;
    }
}