package com.aca.exams.exam03.facade;

import com.aca.exams.exam03.service.core.UserPlateNumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserPlateNumberFacadeImpl implements UserPlateNumberFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserPlateNumberFacadeImpl.class);

    //private final UserPlateNumberService userPlateNumberService;


    @Override
    public UserTakePlateNumberResponseDto takePlateNumber(UserTakePlateNumberRequestDto dto) {


        return null;
    }

    @Override
    public UserGetAllPlateNumbersResponseDto getAllPlateNumbers(UserGetAllPlateNumbersRequestDto dto) {
        return null;
    }
}