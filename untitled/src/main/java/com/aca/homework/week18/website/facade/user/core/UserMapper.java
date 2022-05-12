package com.aca.homework.week18.website.facade.user.core;

import com.aca.homework.week18.website.entity.User;

public interface UserMapper {

    UserSignUpResponseDto mapper(User user);
}
