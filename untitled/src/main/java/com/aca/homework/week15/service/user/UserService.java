package com.aca.homework.week15.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    User create(UserCreateParams params) {
        LOGGER.debug("Creating a user for the provided creation params - ({} , {}) ", params.getUsername(), params.getName());
        User user = new User(params.getUsername(), params.getName());
        userRepository.save(user);
        LOGGER.debug("Successfully created a user for the provided creation params - ({} , {}) ,result - {} ", params.getUsername(), params.getName(), user);
        return user;

    }
}