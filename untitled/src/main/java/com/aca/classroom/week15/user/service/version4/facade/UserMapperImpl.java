package com.aca.classroom.week15.user.service.version4.facade;

import com.aca.classroom.week15.user.service.version4.entity.Diploma;
import com.aca.classroom.week15.user.service.version4.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserMapperImpl implements UserMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserMapperImpl.class);

    @Override
    public UserAdmissionResponseDto map(User user) {
        LOGGER.info("Mapping a user - {} to user admission request dto", user);
        final UserAdmissionResponseDto userAdmissionResponseDto = new UserAdmissionResponseDto(user.getUsername(), user.getFirstName(), user.getSecondName());
        LOGGER.info("Successfully mapped a user - {} to user admission request dto ,result - {}", user, userAdmissionResponseDto);
        return userAdmissionResponseDto;
    }

    @Override
    public UserGraduationResponseDto map(Diploma diploma) {
        LOGGER.debug("Mapping a diploma  {}  to user graduation response dto", diploma);
        User user = diploma.getUser();
        UserGraduationResponseDto userGraduationResponseDto = new UserGraduationResponseDto(user.getFirstName(),
                user.getSecondName(),
                diploma.getStartDate(),
                diploma.getEndDate(),
                diploma.getColorType(),
                "N" + diploma.getId());
        LOGGER.debug("successfully mapped a diploma  {}  to user graduation response dto , result - {}", diploma, userGraduationResponseDto);
        return userGraduationResponseDto;
    }
}