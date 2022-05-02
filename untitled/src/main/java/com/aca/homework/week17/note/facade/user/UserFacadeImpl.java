package com.aca.homework.week17.note.facade.user;


import com.aca.homework.week17.note.service.core.UserCreationParams;
import com.aca.homework.week17.note.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class UserFacadeImpl implements UserFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFacadeImpl.class);
    private final UserService userService;

    public UserFacadeImpl(UserService userService) {
        Assert.notNull(userService, "The provided userService should not be null");
        this.userService = userService;
    }

    @Override
    public UserSignUpResponseDto signUp(UserSignUpRequestDto dto) {
        Assert.notNull(dto, "user sign up request dto param should not be null");
        LOGGER.info("signing up  the user according to the provided request - {}", dto);
        User user = userService.create(
                new UserCreationParams(
                        dto.getUsername(),
                        dto.getFirstName(),
                        dto.getSecondName()
                )
        );
        final UserSignUpResponseDto responseDto = new UserSignUpResponseDto(user.getUsername());
        LOGGER.info(" Successfully  signup user according to the provided request - {}, responseDto - {}", dto, responseDto);
        return responseDto;
    }
}
