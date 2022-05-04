package com.aca.exams.exam03.service.core;

import com.aca.exams.exam03.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User create(UserCreationParams params);

    User getById(Long id);
}
