package com.aca.classroom.week15.user.service.version5.facade;

import com.aca.classroom.week15.user.service.version5.entity.Diploma;
import com.aca.classroom.week15.user.service.version5.entity.DiplomaColorType;
import com.aca.classroom.week15.user.service.version5.entity.User;
import com.aca.classroom.week15.user.service.version5.service.core.CreateDiplomaParams;
import com.aca.classroom.week15.user.service.version5.service.core.CreateUserParams;
import com.aca.classroom.week15.user.service.version5.service.core.DiplomaService;
import com.aca.classroom.week15.user.service.version5.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class UniversityFacadeImpl implements UniversityFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(UniversityFacadeImpl.class);
    private final UserService userService;
    private final DiplomaService diplomaService;
    private final UserMapper userMapper;
    private final String usernamePrefix;

    public UniversityFacadeImpl(final UserService userService, final DiplomaService diplomaService, UserMapper userMapper, @Value("${university.username.prefix}") String usernamePrefix) {
        this.userService = userService;
        this.diplomaService = diplomaService;
        this.userMapper = userMapper;
        this.usernamePrefix = usernamePrefix;
    }

    @Override
    public UserAdmissionResponseDto admit(UserAdmissionRequestDto dto) {
        LOGGER.info("Admitting the user for the provided request - {}", dto);

        User user = userService.create(
                new CreateUserParams(
                        usernamePrefix + dto.getFirstName() + "_" + dto.getSecondName(),
                        dto.getFirstName(),
                        dto.getSecondName(),
                        LocalDate.now(),
                        "password" + dto.getFirstName()
                )
        );
        UserAdmissionResponseDto userAdmissionResponseDto = userMapper.map(user);
        LOGGER.info("Successfully admitted a student for the provided request - {},response -{}", dto, userAdmissionResponseDto);
        return userAdmissionResponseDto;
    }

    @Override
    public UserGraduationResponseDto graduate(UserGraduationRequestDto dto) {
        Assert.notNull(dto, "the user graduation dto should not be null");
        LOGGER.debug("Starting graduation process fro the provided dto - {}", dto);
        Optional<User> userOptional = userService.findByUsername(dto.getUsername());

        if (userOptional.isEmpty()) {
            return new UserGraduationResponseDto(List.of("user not found"));
        }

        User user = userOptional.get();
        final Diploma diploma = diplomaService.create(new CreateDiplomaParams(
                DiplomaColorType.RED,
                user.getCreatedAt(),
                LocalDate.now(),
                user.getId()
        ));
        UserGraduationResponseDto responseDto = userMapper.map(diploma);
        LOGGER.debug("starting graduation process for the provided dto -{}, result - {}", dto, responseDto);
        return responseDto;
    }
    @PostConstruct
    public void test(){
        System.out.println();
    }
}
//cntrlP tesnum enq dashter@