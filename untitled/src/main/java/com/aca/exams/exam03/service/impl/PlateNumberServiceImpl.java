package com.aca.exams.exam03.service.impl;

import com.aca.exams.exam03.entity.PlateNumber;
import com.aca.exams.exam03.repository.PlateNumberRepository;
import com.aca.exams.exam03.service.core.PlateNumberCreationParams;
import com.aca.exams.exam03.service.core.PlateNumberService;
import com.aca.homework.week17.note.entity.User;
import com.aca.homework.week17.note.service.impl.UserNoteFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.Optional;

public class PlateNumberServiceImpl implements PlateNumberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlateNumberServiceImpl.class);

    private final PlateNumberRepository plateNumberRepository;

    public PlateNumberServiceImpl(PlateNumberRepository plateNumberRepository) {
        Assert.notNull(plateNumberRepository, "plateNumber repository cannot be null");
        this.plateNumberRepository = plateNumberRepository;
    }

    @Override
    public PlateNumber create(PlateNumberCreationParams params) {
        Assert.notNull(params, "the params cannot be null");
        LOGGER.info("Creating end saving plateNumber for the provided params - {}", params);
        final PlateNumber plateNumber = new PlateNumber(params.getPlateNumber());
        PlateNumber savedPlateNumber = plateNumberRepository.save(plateNumber);
        LOGGER.info("Successfully created end saved a plateNumber for the provided params - {},", params);
        return savedPlateNumber;
    }

    @Override
    public PlateNumber getById(Long id) {
        Assert.notNull(id, "id should not be null ");
        LOGGER.info("Retrieving plateNumber for the provided id - {}", id);
        final Optional<PlateNumber> userOptional = plateNumberRepository.findById(id);
        PlateNumber plateNumber = userOptional.orElseThrow(() -> new UserNoteFoundException(id));
        LOGGER.info("Successfully retrieved the user for the provided userid - {}, result - {}", id, plateNumber);
        return plateNumber;
    }
}