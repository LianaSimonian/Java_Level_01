package com.aca.classroom.week17.note.service.core;


import com.aca.classroom.week17.note.entity.User;

public interface UserService {

    User create(UserCreationParams params);

    User getById(Long id);

    User getByUsername(String username);

}