package com.aca;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(CreateUserParams params) {
        LOGGER.debug("Createing a user for provided parapms -{}", params);
        User user = new User(params.getFirst_name(), params.getSecond_name());
        User savedUser = userRepository.save(user);
        LOGGER.debug("Successfully created for provided parapms -{}", params);
        return savedUser;
    }
}
