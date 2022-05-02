package com.aca.homework.week17.note.service.core;

public interface UserService {

    User create(UserCreationParams params);

    User getById(Long id);

    User getByUsername(String username);

}
