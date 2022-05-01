package com.aca.classroom.week15.user.service.version3.service.core;

import com.aca.classroom.week15.user.service.version3.entity.User;

public interface UserService {

    User create(CreateUserParams params);

    User getByUsername(String username);

    User getById(Long id);
}
//abstractianeer@ corei mej u dra het kapvath paramser@