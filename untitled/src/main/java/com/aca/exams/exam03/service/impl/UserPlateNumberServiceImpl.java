package com.aca.exams.exam03.service.impl;

import com.aca.exams.exam03.entity.PlateNumber;
import com.aca.exams.exam03.entity.User;
import com.aca.exams.exam03.entity.UserPlateNumber;
import com.aca.exams.exam03.repository.UserPlateNumberRepository;
import com.aca.exams.exam03.service.core.PlateNumberService;
import com.aca.exams.exam03.service.core.UserPlateNumberCreationParams;
import com.aca.exams.exam03.service.core.UserPlateNumberService;
import com.aca.exams.exam03.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class UserPlateNumberServiceImpl implements UserPlateNumberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserPlateNumberServiceImpl.class);

    private final UserPlateNumberRepository userPlateNumberRepository;
    private final UserService userService;
    private final PlateNumberService plateNumberService;

    public UserPlateNumberServiceImpl(UserPlateNumberRepository userPlateNumberRepository, UserService userService, PlateNumberService plateNumberService) {
        Assert.notNull(userPlateNumberRepository, "user plate repository cannot be null");
        Assert.notNull(userService, "user service cannot be null");
        Assert.notNull(plateNumberService, "plate number service cannot be null");
        this.userPlateNumberRepository = userPlateNumberRepository;
        this.userService = userService;
        this.plateNumberService = plateNumberService;
    }

    @Override
    public UserPlateNumber create(UserPlateNumberCreationParams params) {
        Assert.notNull(params, "the params cannot be null");
        LOGGER.info("Creating end saving userPlateNumber for the provided params - {}", params);
        User user = userService.getById(params.getUserId());
        PlateNumber plateNumber = plateNumberService.getById(params.getPlateNumberId());
        final UserPlateNumber userPlateNumber = new UserPlateNumber(plateNumber, user, params.getCreationDate());
        UserPlateNumber savedUserPlateNumber = userPlateNumberRepository.save(userPlateNumber);
        LOGGER.info("Successfully created end saved a user for the provided params - {},", params);
        return savedUserPlateNumber;
    }

    @Override
    public User getByPlateNumber(PlateNumber plateNumber) {

        return null;
    }
}