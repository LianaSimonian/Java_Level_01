package com.aca.classroom.week15.user.service.version3.service.impl;

import com.aca.classroom.week15.user.service.version3.entity.Diploma;
import com.aca.classroom.week15.user.service.version3.entity.User;
import com.aca.classroom.week15.user.service.version3.repository.DiplomaRepository;

import com.aca.classroom.week15.user.service.version3.service.core.CreateDiplomaParams;
import com.aca.classroom.week15.user.service.version3.service.core.DiplomaService;
import com.aca.classroom.week15.user.service.version3.service.core.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class DiplomaServiceImpl implements DiplomaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DiplomaServiceImpl.class);
    private final DiplomaRepository diplomaRepository;
    private final UserService userService;

    public DiplomaServiceImpl(DiplomaRepository diplomaRepository, UserService userService) {
        this.userService = userService;
        this.diplomaRepository = diplomaRepository;
    }

    @Override
    public Diploma create(CreateDiplomaParams params) {
        Assert.notNull(params, "The provided  params should not be null");

        LOGGER.info("Creating a diploma for the provided params - {}", params);

        final User user = userService.getById(params.getUserId());
        Diploma transientDiploma = new Diploma(
                params.getColorType(),
                params.getStartDate(),
                params.getEndDate(),
                user);
        final Diploma persistentDiploma = diplomaRepository.save(transientDiploma);

        LOGGER.info("Successfully created a diploma for the provided params - {}", params);
        return persistentDiploma;
    }
}
