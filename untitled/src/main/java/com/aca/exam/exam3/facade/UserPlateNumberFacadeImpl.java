package com.aca.exam.exam3.facade;

import com.aca.exam.exam3.entity.UserPlateNumber;
import com.aca.exam.exam3.service.core.PlateNumberCreationParams;
import com.aca.exam.exam3.service.core.UserPlateNumberService;
import com.aca.exam.exam3.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.time.LocalDate;

public class UserPlateNumberFacadeImpl implements UserPlateNumberFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserPlateNumberFacadeImpl.class);

    private final UserPlateNumberService plateNumberService;
    private final UserService userService;

    public UserPlateNumberFacadeImpl(UserPlateNumberService plateNumberService, UserService userService) {
        Assert.notNull(plateNumberService, "The provided plateNumberService should not be null");
        Assert.notNull(userService, "The provided userService should not be null");
        this.plateNumberService = plateNumberService;
        this.userService = userService;
    }

    @Override
    public PlateNumberResponseDto create(PlateNumberRequestDto dto) {
        Assert.notNull(dto, "plateNumber creation request dto param should not be null");
        LOGGER.info("creating the plateNumber  according to the provided request - {}", dto);
        final UserPlateNumber userPlateNumber = plateNumberService.create(new PlateNumberCreationParams(
                "ABS0001",
                dto.getUserId(),
                LocalDate.now()
        ));
        PlateNumberResponseDto responseDto = new PlateNumberResponseDto(userPlateNumber.getId(), userPlateNumber.getPlateNumber(), userPlateNumber.getCreationDate());
        LOGGER.info(" Successfully created plateNumber  according to the provided request - {}, responseDto - {}", dto, responseDto);
        return responseDto;
    }
}