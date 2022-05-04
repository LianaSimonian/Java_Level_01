package com.aca.exams.exam03.facade;

public interface UserPlateNumberFacade {

    UserTakePlateNumberResponseDto takePlateNumber(UserTakePlateNumberRequestDto dto);

    UserGetAllPlateNumbersResponseDto getAllPlateNumbers(UserGetAllPlateNumbersRequestDto dto);
}