package com.aca.classroom.week15.user.service.version04.facade;


import com.aca.classroom.week15.user.service.version04.entity.Diploma;
import com.aca.classroom.week15.user.service.version04.entity.User;

public interface UserMapper {

    UserAdmissionResponseDto map(User user);

    UserGraduationResponseDto map(Diploma diploma);
}