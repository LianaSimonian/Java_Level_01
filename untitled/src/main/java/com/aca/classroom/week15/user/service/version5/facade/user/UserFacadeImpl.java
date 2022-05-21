package com.aca.classroom.week15.user.service.version5.facade.user;

import com.aca.classroom.week15.user.service.version5.entity.User;
import com.aca.classroom.week15.user.service.version5.service.core.CreateUserParams;
import com.aca.classroom.week15.user.service.version5.service.core.UserService;
import com.aca.dto.UserSignUpRequestDto;
import com.aca.dto.UserSignUpResponseDto;


import java.time.LocalDate;

public class UserFacadeImpl implements UserFacade {

    private final UserService userService;

    public UserFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserSignUpResponseDto signUp(UserSignUpRequestDto requestDto) {

        User user = userService.create(new CreateUserParams(requestDto.getUsername(),
                requestDto.getFirstName(),
                requestDto.getSecondName(),
                LocalDate.now(),
                requestDto.getPassword()));

        UserSignUpResponseDto responseDto = new UserSignUpResponseDto(user.getUsername(),
                user.getFirstName(),
                user.getSecondName(),
                user.getCreatedAt());
        return responseDto;
    }
}
