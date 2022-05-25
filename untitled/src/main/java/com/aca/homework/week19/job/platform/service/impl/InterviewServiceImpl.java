package com.aca.homework.week19.job.platform.service.impl;

import com.aca.homework.week19.job.platform.entity.Interview;
import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.exceptions.InterviewNotFoundException;
import com.aca.homework.week19.job.platform.exceptions.OrganizationNotFoundException;
import com.aca.homework.week19.job.platform.exceptions.UserNotFoundException;
import com.aca.homework.week19.job.platform.repository.InterviewRepository;
import com.aca.homework.week19.job.platform.service.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class InterviewServiceImpl implements InterviewService {

    private final static Logger LOGGER = LoggerFactory.getLogger(InterviewServiceImpl.class);

    private final InterviewRepository interviewRepository;
    private final UserService userService;
    private final OrganizationService organizationService;

    public InterviewServiceImpl(InterviewRepository interviewRepository, UserService userService, OrganizationService organizationService) {
        Assert.notNull(interviewRepository, "The interviewRepository cannot be null");
        Assert.notNull(userService, "the userService cannot be null");
        Assert.notNull(organizationService, "the organizationService cannot be null");
        this.interviewRepository = interviewRepository;
        this.userService = userService;
        this.organizationService = organizationService;
    }

    @Override
    public Interview create(CreateInterviewParams params) {
        Assert.notNull(params, "The provided  params should not be null");
        LOGGER.info("Creating and saving an interview for the provided params - {}", params);
        Optional<User> userOptional = userService.findById(params.getUserId());
        final User user = userOptional.orElseThrow(() -> new UserNotFoundException(params.getUserId()));

        Optional<Organization> organizationOptional = organizationService.findById(params.getOrganizationId());
        final Organization organization = organizationOptional.orElseThrow(() -> new OrganizationNotFoundException(params.getOrganizationId()));

        final Interview transientInterview = new Interview(
                user,
                params.getDateTime(),
                params.getStatus(),
                organization
        );
        final Interview persistentInterview = interviewRepository.save(transientInterview);
        LOGGER.info("Successfully created and saved an interview for the provided params - {}", params);
        return persistentInterview;
    }

    @Override
    public Interview update(UpdateInterviewParams params) {
        Assert.notNull(params, "The provided params should not be null");
        LOGGER.info("Updating an interview for the provided params - {}", params);

        Long interviewId = params.getInterviewId();
        Optional<Interview> interviewOptional = interviewRepository.findById(interviewId);
        Interview interview = interviewOptional.orElseThrow(() -> new InterviewNotFoundException(interviewId));

        interview.setStatus(params.getStatus());
        interview.setDateTime(params.getDateTime());
        final Interview updatedInterview = interviewRepository.save(interview);
        LOGGER.info("Successfully updated an interview for the provided params - {}, result - {}", params, updatedInterview);
        return updatedInterview;
    }

    @Override
    public Optional<Interview> findByOrganizationIdAndUserId(Long organizationId, Long userId) {
        Assert.notNull(organizationId, "organizationId should not be null or empty");
        Assert.notNull(userId, "userId should not be null or empty");
        LOGGER.info("retrieving the interview for the provided organizationId - {} and userId - {}", organizationId, userId);
        final Optional<Interview> interviewOptional = interviewRepository.findByOrganizationIdAndUserId(organizationId, userId);
        LOGGER.info("Successfully retrieved the interview for the provided organizationId - {} and userId - {}, result - {}", organizationId, userId, interviewOptional);
        return interviewOptional;
    }
}