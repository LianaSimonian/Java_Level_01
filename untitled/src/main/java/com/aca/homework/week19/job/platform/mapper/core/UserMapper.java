package com.aca.homework.week19.job.platform.mapper.core;

import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.dto.UserDetailsDto;

public interface UserMapper {

    UserDetailsDto mapper(User user);
}