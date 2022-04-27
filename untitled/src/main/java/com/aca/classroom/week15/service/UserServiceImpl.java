package com.aca.classroom.week15.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository) {
        Assert.notNull(userRepository, "user repository cannot be null");
        this.userRepository = userRepository;
    }

    @Override
    public User create(CreateUserParams params) {
        Assert.notNull(params, "the params cannot be null");
        LOGGER.info("Creating user for the provided params - {}", params);
        // TODO: 25.04.2022  replace null username
        User user = new User(params.getUsername(), params.getFirstName(), params.getSecondName());
        User savedUser = userRepository.save(user);
        LOGGER.info("Successfully created a user for the provided params - {}", params);
        return savedUser;
    }

    @Override
    public User getByUsername(String username) {
        Assert.hasText(username, "Username should not be null or empty");
        LOGGER.info("Retrieving user for the provided username - {}", username);
        final Optional<User> userOptional = userRepository.findByUsername(username);
/*
        Optional<User> userOptional = userRepository.findByUsername(username);
        User user = userOptional.orElseThrow(() -> new UserNotFoundException(username));
 */
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException(username);
        }
        final User user = userOptional.get();
        LOGGER.info("Successfully retrieved the user for the provided username - {}, result - {}", username, user);

        return user;
    }
}