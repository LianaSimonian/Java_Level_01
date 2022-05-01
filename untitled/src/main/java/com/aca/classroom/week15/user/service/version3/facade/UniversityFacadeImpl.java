package com.aca.classroom.week15.user.service.version3.facade;

import com.aca.classroom.week15.user.service.version3.entity.User;
import com.aca.classroom.week15.user.service.version3.service.core.CreateUserParams;
import com.aca.classroom.week15.user.service.version3.service.core.DiplomaService;
import com.aca.classroom.week15.user.service.version3.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UniversityFacadeImpl implements UniversityFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(UniversityFacadeImpl.class);
    private final UserService userService;
    private final DiplomaService diplomaService;

    public UniversityFacadeImpl(final UserService userService, final DiplomaService diplomaService) {
        this.userService = userService;
        this.diplomaService = diplomaService;
    }

    @Override
    public UserAdmissionResponseDto admit(UserAdmissionRequestDto dto) {
        LOGGER.info("Admitting the user for the provided request - {}", dto);

        User user = userService.create(
                new CreateUserParams(
                        dto.getFirstName() + "_" + dto.getSecondName(),
                        dto.getFirstName(),
                        dto.getSecondName()
                )
        );

        return new UserAdmissionResponseDto(user.getUsername(), user.getFirstName(), user.getSecondName());
    }
}