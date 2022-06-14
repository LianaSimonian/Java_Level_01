package com.aca.homework.week19.job.platform.facade.core;

import com.aca.homework.week19.job.platform.dto.UserDetailsDto;
import com.aca.homework.week19.job.platform.dto.UserSignUpRequestDto;

public interface UserFacade {

    UserDetailsDto signUp(UserSignUpRequestDto dto);

    UserDetailsDto getUserDetails(Long userId);

    UserDetailsDto openToWork(Long userId);
}
