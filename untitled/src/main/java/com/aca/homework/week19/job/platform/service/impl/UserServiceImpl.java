package com.aca.homework.week19.job.platform.service.impl;

import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.exceptions.UserNotFoundException;
import com.aca.homework.week19.job.platform.repository.UserRepository;
import com.aca.homework.week19.job.platform.service.core.CreateUserParams;
import com.aca.homework.week19.job.platform.service.core.UpdateUserParams;
import com.aca.homework.week19.job.platform.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        Assert.notNull(userRepository, "the userRepository cannot be null");
        this.userRepository = userRepository;
    }

    @Override
    public User create(CreateUserParams params) {
        Assert.notNull(params, "The provided  params should not be null");
        LOGGER.info("Creating and saving a user for the provided params - {}", params);
        final User transientUser = new User(params.getFirstName(),
                params.getSecondName(),
                params.getUsername(),
                params.getPassword(),
                params.isOpenForJobOffers());
        final User persistentUser = userRepository.save(transientUser);
        LOGGER.info("Successfully created and saved a user for the provided params - {},", params);
        return persistentUser;
    }

    @Override
    public Optional<User> findById(Long id) {
        Assert.notNull(id, "user id should not be null");
        LOGGER.info("Retrieving user for the provided user id  - {}", id);
        final Optional<User> userOptional = userRepository.findById(id);
        LOGGER.info("Successfully retrieved the user for the provided id - {}, result - {}", id, userOptional);
        return userOptional;
    }

    @Override
    public User update(UpdateUserParams params) {
        Assert.notNull(params, "The provided  params should not be null");
        LOGGER.info("updating the user according to the provided param - {}", params);
        Optional<User> userOptional = userRepository.findById(params.getUserId());
        User user = userOptional.orElseThrow(() -> new UserNotFoundException(params.getUserId()));

        user.setUsername(params.getUsername());
        user.setPassword(params.getPassword());
        user.setOpenForJobOffers(params.isOpenForJobOffers());

        User updatedUser = userRepository.save(user);
        LOGGER.info("updated the user according to the provided param - {}, result -{}", params, updatedUser);
        return updatedUser;
    }

    @Override
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        Assert.hasText(username, "username should not be null or empty");
        Assert.hasText(password, "password should not be null or empty");
        LOGGER.info(" retrieving the user for the provided password - {} and username - {}", password, username);
        final Optional<User> userOptional = userRepository.findByUsernameAndPassword(username, password);
        LOGGER.info("Successfully retrieved the user for the provided password - {} and username - {}, result - {}", password, username, userOptional);
        return userOptional;
    }
}