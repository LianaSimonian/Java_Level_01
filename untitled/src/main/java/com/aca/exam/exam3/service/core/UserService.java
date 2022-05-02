package com.aca.exam.exam3.service.core;

import com.aca.exam.exam3.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User create(UserCreationParams params);

    User getById(Long id);
}