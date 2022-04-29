package com.aca.classroom.week15.user.service.version2;

public interface UserService {

    User create(CreateUserParams params);

    User getByUsername(String username);
}