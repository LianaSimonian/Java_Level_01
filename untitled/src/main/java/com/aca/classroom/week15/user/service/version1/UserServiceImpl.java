package com.aca.classroom.week15.user.service.version1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(final CreateUserParams params) {
        LOGGER.debug("Creating a user for the provided params - {}", params);

        final User user = new User(params.getFirstName(), params.getSecondName());
        final User savedUser = userRepository.save(user);

        LOGGER.debug("Successfully created a user for the provided params - {}", params);
        return savedUser;
    }
}