package com.aca.homework.week17.note.service.impl;

import com.aca.homework.week17.note.repository.UserRepository;
import com.aca.homework.week17.note.service.core.UserCreationParams;
import com.aca.homework.week17.note.service.core.UserService;
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
    public User create(UserCreationParams params) {
        Assert.notNull(params, "the params cannot be null");
        LOGGER.info("Creating end saving user for the provided params - {}", params);
        final User user = new User(params.getUsername(), params.getFirstName(), params.getSecondName());
        User savedUser = userRepository.save(user);
        LOGGER.info("Successfully created end saved a user for the provided params - {}", params);
        return savedUser;
    }

    @Override
    public User getById(Long id) {
        Assert.notNull(id, "id should not be null ");
        LOGGER.info("Retrieving user for the provided userid - {}", id);
        final Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new UserNoteFoundException(id);
        }
        final User user = userOptional.get();
        LOGGER.info("Successfully retrieved the user for the provided userid - {}, result - {}", id, user);
        return user;
    }

    @Override
    public User getByUsername(String username) {
        Assert.hasText(username, "Username should not be null or empty");
        LOGGER.info("Retrieving user for the provided username - {}", username);
        final Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new UserNoteFoundException(username);
        }
        final User user = userOptional.get();
        LOGGER.info("Successfully retrieved the user for the provided username - {}, result - {}", username, user);
        return user;
    }
}