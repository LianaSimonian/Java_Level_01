package com.aca.classroom.week15.user.service.version5.service.impl;

import com.aca.classroom.week15.user.service.version5.entity.UserRole;
import com.aca.classroom.week15.user.service.version5.entity.UserRoleType;
import com.aca.classroom.week15.user.service.version5.service.core.CreateUserParams;
import com.aca.classroom.week15.user.service.version5.service.core.UserService;
import com.aca.classroom.week15.user.service.version5.entity.User;
import com.aca.classroom.week15.user.service.version5.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        Assert.notNull(userRepository, "user repository cannot be null");
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    //@Transactional(readOnly = true)
    //debug enter end set id =1
    @Transactional
    public User create(CreateUserParams params) {
        Assert.notNull(params, "the params cannot be null");
        LOGGER.info("Creating user for the provided params - {}", params);
        final String encodedPassword = passwordEncoder.encode(params.getPassword());
        // TODO: 25.04.2022  replace null username
        User user = new User(params.getUsername(), params.getFirstName(), params.getSecondName(), params.getCreatedAt(), encodedPassword);
        user.setUserRoles(List.of(new UserRole(user, UserRoleType.STUDENT)));//dbum chi avelacnelu
        User savedUser = userRepository.save(user);
        LOGGER.info("Successfully created a user for the provided params - {}, saved user - {}", params, savedUser);
        return savedUser;
    }

    @Override
    @Transactional(readOnly = true)
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

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByUsername(String username) {
        Assert.hasText(username, "Username should not be null or empty");
        LOGGER.info("Retrieving user for the provided username - {}", username);
        final Optional<User> userOptional = userRepository.findByUsername(username);
/*
        Optional<User> userOptional = userRepository.findByUsername(username);
        User user = userOptional.orElseThrow(() -> new UserNotFoundException(username));
 */
        LOGGER.info("Successfully retrieved the user for the provided username - {}, result - {}", username, userOptional);

        return userOptional;
    }

    @Override
    public User getById(Long id) {
        Assert.notNull(id, "id should not be null ");
        LOGGER.info("Retrieving user for the provided userid - {}", id);
        final Optional<User> userOptional = userRepository.findById(id);
/*
        Optional<User> userOptional = userRepository.findByUsername(username);
        User user = userOptional.orElseThrow(() -> new UserNotFoundException(username));
 */
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException(id);
        }
        final User user = userOptional.get();
        LOGGER.info("Successfully retrieved the user for the provided userid - {}, result - {}", id, user);

        return user;
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        /*
        //Monad design partern
        Optional<String> passwordOptional = userRepository.findByUsername(username).map(user -> user.getPassword());
        passwordEncoder.matches(password, );
        return false;
        //supplier
        //callable
        //orelse,orelseget difference
         */
        return userRepository.findByUsername(username).map(user -> user.getPassword())
                .map(encryptedPassword -> passwordEncoder.matches(password, encryptedPassword)).orElse(false);
    }

    @PostConstruct
    public void test() {
        System.out.println("test");
    }
}
//spring security
//forin case atontication
//pojo
//token
//oout2
//token teak
//outotication mechanizm'//jwtToken