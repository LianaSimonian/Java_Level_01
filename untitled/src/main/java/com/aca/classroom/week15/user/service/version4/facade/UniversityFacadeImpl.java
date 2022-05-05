package com.aca.classroom.week15.user.service.version4.facade;

import com.aca.classroom.week15.user.service.version4.entity.Diploma;
import com.aca.classroom.week15.user.service.version4.entity.DiplomaColorType;
import com.aca.classroom.week15.user.service.version4.entity.User;
import com.aca.classroom.week15.user.service.version4.service.core.CreateDiplomaParams;
import com.aca.classroom.week15.user.service.version4.service.core.CreateUserParams;
import com.aca.classroom.week15.user.service.version4.service.core.DiplomaService;
import com.aca.classroom.week15.user.service.version4.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class UniversityFacadeImpl implements UniversityFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(UniversityFacadeImpl.class);
    private final UserService userService;
    private final DiplomaService diplomaService;
    private final UserMapper userMapper;

    public UniversityFacadeImpl(final UserService userService, final DiplomaService diplomaService,UserMapper userMapper) {
        this.userService = userService;
        this.diplomaService = diplomaService;
        this.userMapper = userMapper;
    }

    @Override
    public UserAdmissionResponseDto admit(UserAdmissionRequestDto dto) {
        LOGGER.info("Admitting the user for the provided request - {}", dto);

        User user = userService.create(
                new CreateUserParams(
                        dto.getFirstName() + "_" + dto.getSecondName(),
                        dto.getFirstName(),
                        dto.getSecondName(),
                        LocalDate.now()
                )
        );
        UserAdmissionResponseDto userAdmissionResponseDto=userMapper.map(user);
        //UserAdmissionResponseDto userAdmissionResponseDto = new UserAdmissionResponseDto(user.getUsername(), user.getFirstName(), user.getSecondName());
        LOGGER.info("Successgully addmiited a student for the provided request - {},response -{}",dto,userAdmissionResponseDto);
        return userAdmissionResponseDto;
    }

    @Override
    public UserGraduationResponseDto graduate(UserGraduationRequestDto dto) {
        Assert.notNull(dto,"the user graduation dto should not be null");

       Optional<User> userOptional= userService.findByUsername(dto.getUsername());

       if(userOptional.isEmpty()){
           return new UserGraduationResponseDto(List.of("user not found"));
       }

        User user = userOptional.get();
        final Diploma diploma = diplomaService.create(new CreateDiplomaParams(
                DiplomaColorType.RED,
                user.getCreatedAt(),
                LocalDate.now(),
                user.getId()

        ));
     UserGraduationResponseDto responseDto  =userMapper.map(diploma);
        LOGGER.debug("starting graduation process for the provided dto -{}",dto);
        return null;
    }
}
//cntrlP tesnum enq dashter@