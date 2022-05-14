package com.aca.classroom.week15.user.service.version4.service.core;

import com.aca.classroom.week15.user.service.version4.entity.User;

import java.util.Optional;

public interface UserService {

    User create(CreateUserParams params);

    User getByUsername(String username);

    User getById(Long id);

    Optional<User> findByUsername(String username);//
}
//abstractianeer@ corei mej u dra het kapvath paramser@