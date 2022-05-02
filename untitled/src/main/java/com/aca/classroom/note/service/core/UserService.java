package com.aca.classroom.note.service.core;

import com.aca.classroom.note.entity.User;

public interface UserService {

    User create(UserCreationParams params);

    User getById(Long id);

    User getByUsername(String username);

}
