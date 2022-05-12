package com.aca.homework.week18.website.service.core;

import com.aca.homework.week18.website.entity.User;

import java.util.Optional;

public interface UserService {

    User create(CreateUserParams params);

    Optional<User> findByUsername(String username);

    Optional<User> findByPassword(String password);

    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findById(Long id);
}