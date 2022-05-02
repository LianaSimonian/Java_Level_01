package com.aca.exam.exam3.service.impl;

import com.aca.exam.exam3.entity.User;
import com.aca.exam.exam3.entity.UserPlateNumber;
import com.aca.exam.exam3.repository.PlateNumberRepository;
import com.aca.exam.exam3.service.core.PlateNumberCreationParams;
import com.aca.exam.exam3.service.core.UserPlateNumberService;
import com.aca.exam.exam3.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class UserPlateNumberServiceImpl implements UserPlateNumberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserPlateNumberServiceImpl.class);

    private final PlateNumberRepository plateNumberRepository;
    private final UserService userService;

    public UserPlateNumberServiceImpl(PlateNumberRepository plateNumberRepository, UserService userService) {
        Assert.notNull(plateNumberRepository, "note repository cannot be null");
        Assert.notNull(userService, "user service cannot be null");
        this.plateNumberRepository = plateNumberRepository;
        this.userService = userService;
    }

    @Override
    public UserPlateNumber create(PlateNumberCreationParams params) {
        Assert.notNull(params, "The provided  params should not be null");
        LOGGER.info("Creating a userPlateNumber  for the provided params - {}", params);
        final User user = userService.getById(params.getUserId());
        UserPlateNumber transientPlateNumber = new UserPlateNumber(
                params.getPlateNumber(),
                user,
                params.getCreationDate());
        final UserPlateNumber persistentPlateNumber = plateNumberRepository.save(transientPlateNumber);
        LOGGER.info("Successfully created a plate number for the provided params - {}", params);
        return persistentPlateNumber;
    }
}