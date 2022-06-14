package com.aca.homework.week19.job.platform.service.impl;

import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.entity.UserOrganization;
import com.aca.homework.week19.job.platform.exceptions.OrganizationNotFoundException;
import com.aca.homework.week19.job.platform.exceptions.UserNotFoundException;
import com.aca.homework.week19.job.platform.repository.UserOrganizationRepository;
import com.aca.homework.week19.job.platform.service.core.CreateUserOrganizationParams;
import com.aca.homework.week19.job.platform.service.core.OrganizationService;
import com.aca.homework.week19.job.platform.service.core.UserOrganizationService;
import com.aca.homework.week19.job.platform.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class UserOrganizationServiceImpl implements UserOrganizationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserOrganizationServiceImpl.class);

    private final UserService userService;
    private final OrganizationService organizationService;
    private final UserOrganizationRepository userOrganizationRepository;

    public UserOrganizationServiceImpl(UserService userService, OrganizationService organizationService, UserOrganizationRepository userOrganizationRepository) {
        Assert.notNull(userService, "the userService cannot be  null");
        Assert.notNull(organizationService, "the organizationService cannot be null");
        Assert.notNull(userOrganizationRepository, "the userOrganizationRepository cannot be  null");
        this.userService = userService;
        this.organizationService = organizationService;
        this.userOrganizationRepository = userOrganizationRepository;
    }

    @Override
    public UserOrganization create(CreateUserOrganizationParams params) {
        Assert.notNull(params, "The provided  params should not be null");
        LOGGER.info("Creating and saving a userOrganization for the provided params - {}", params);
        Long userId = params.getUserId();
        Optional<User> userOptional = userService.findById(userId);
        final User user = userOptional.orElseThrow(() -> new UserNotFoundException(userId));

        Long organizationId = params.getOrganizationId();
        Optional<Organization> organizationOptional = organizationService.findById(organizationId);
        final Organization organization = organizationOptional.orElseThrow(() -> new OrganizationNotFoundException(organizationId));

        UserOrganization transientUserOrganization = new UserOrganization(
                user,
                organization,
                params.getStartDate()
        );

        UserOrganization persistentUserOrganization = userOrganizationRepository.save(transientUserOrganization);
        LOGGER.info("Successfully created and saved a userOrganization for the provided params - {}, result - {}", params, persistentUserOrganization);
        return persistentUserOrganization;
    }

    @Override
    public List<UserOrganization> findAllByOrganizationId(Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.info("Retrieving list of UserOrganization objects according to the provided userid - {}", id);
        List<UserOrganization> userOrganizations = userOrganizationRepository.findAllByOrganizationId(id);
        LOGGER.info("Successfully retrieved list of UserOrganization objects according to the provided userid - {} , result - {}", id, userOrganizations);
        return userOrganizations;
    }

    @Override
    public Optional<UserOrganization> findByUserId(Long userId) {
        Assert.notNull(userId, "the userId cannot be null");
        LOGGER.info("Retrieving the UserOrganization  according to the provided userId - {}", userId);
        Optional<UserOrganization> userOrganizationOptional = userOrganizationRepository.findByUserId(userId);
        LOGGER.info("Successfully retrieved the UserOrganization according to the provided userId - {} , result - {}", userId, userOrganizationOptional);
        return userOrganizationOptional;
    }

    @Override
    public void deleteByUserId(Long id) {
        Assert.notNull(id, "the user id cannot be null");
        LOGGER.info("deleting the UserOrganization with id - {}", id);
        userOrganizationRepository.deleteByUserId(id);
        LOGGER.info("Successfully deleted the UserOrganization with id - {}", id);
    }
}