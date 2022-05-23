package com.aca.classroom.week15.user.service.version5.facade.user;

import com.aca.classroom.week15.user.service.version5.dto.UserSignUpRequestDto;
import com.aca.classroom.week15.user.service.version5.dto.UserSignUpResponseDto;

public interface UserFacade {

    UserSignUpResponseDto signUp(UserSignUpRequestDto requestDto);
}
