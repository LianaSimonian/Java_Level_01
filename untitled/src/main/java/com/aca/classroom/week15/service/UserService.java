package com.aca.classroom.week15.service;

public interface UserService {

    User create(CreateUserParams params);

    User getByUsername(String username);
}
