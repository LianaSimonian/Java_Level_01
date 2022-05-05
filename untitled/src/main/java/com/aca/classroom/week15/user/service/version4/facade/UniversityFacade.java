package com.aca.classroom.week15.user.service.version4.facade;

public interface UniversityFacade {

    UserAdmissionResponseDto admit(UserAdmissionRequestDto dto);

    UserGraduationResponseDto graduate(UserGraduationRequestDto dto);


}