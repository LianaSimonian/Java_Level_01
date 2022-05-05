package com.aca.classroom.week15.user.service.version4.facade;


import com.aca.classroom.week15.user.service.version4.entity.Diploma;
import com.aca.classroom.week15.user.service.version4.entity.User;

public interface UserMapper {

    UserAdmissionResponseDto map(User user);

    UserGraduationResponseDto map(Diploma diploma);
}