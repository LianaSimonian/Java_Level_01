package com.aca.homework.week18.website.service.impl;

import com.aca.homework.week17.note.entity.Note;
import com.aca.homework.week18.website.entity.User;
import com.aca.homework.week18.website.repository.UserRepository;
import com.aca.homework.week18.website.service.core.CreateUserParams;
import com.aca.homework.week18.website.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        Assert.notNull(userRepository, "user repository cannot be null");
        this.userRepository = userRepository;
    }

    @Override
    public User create(CreateUserParams params) {
        Assert.notNull(params, "the params cannot be null");
        LOGGER.info("Creating end saving user for the provided params - {}", params);
        final User transientUser = new User(params.getFirstName(),
                params.getSecondName(),
                params.getUsername(),
                params.getPassword(),
                params.getSignUpDate());
        final User persistentUser = userRepository.save(transientUser);
        LOGGER.info("Successfully created end saved a user for the provided params - {},", params);
        return persistentUser;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        Assert.hasText(username, "username should not be null or empty");
        LOGGER.info("Retrieving user for the provided username - {}", username);
        final Optional<User> userOptional = userRepository.findByUsername(username);
        LOGGER.info("Successfully retrieved the user for the provided username - {}, result - {}", username, userOptional);
        return userOptional;
    }

    @Override
    public Optional<User> findByPassword(String password) {
        Assert.hasText(password, "password should not be null or empty");
        LOGGER.info("Retrieving user for the provided password - {}", password);
        final Optional<User> userOptional = userRepository.findByPassword(password);
        LOGGER.info("Successfully retrieved the user for the provided password - {}, result - {}", password, userOptional);
        return userOptional;
    }

    @Override
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        Assert.hasText(username, "username should not be null or empty");
        Assert.hasText(password, "password should not be null or empty");
        final Optional<User> userOptional = userRepository.findByUsernameAndPassword(username, password);
        LOGGER.info("Successfully retrieved the user for the provided password - {}, result - {}", password, userOptional);
        return userOptional;
    }

    @Override
    public Optional<User> findById(Long id) {
        Assert.notNull(id, "user id should not be null");
        LOGGER.info("Retrieving user for the provided user id  - {}", id);
        final Optional<User> userOptional = userRepository.findById(id);
        LOGGER.info("Successfully retrieved the user for the provided id - {}, result - {}", id, userOptional);
        return userOptional;
    }
}