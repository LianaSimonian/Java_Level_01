package com.aca.homework.week19.job.platform.service.impl;

import com.aca.homework.week19.job.platform.entity.Invitation;
import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.exceptions.InvitationNotFoundException;
import com.aca.homework.week19.job.platform.exceptions.OrganizationNotFoundException;
import com.aca.homework.week19.job.platform.exceptions.UserNotFoundException;
import com.aca.homework.week19.job.platform.repository.InvitationRepository;
import com.aca.homework.week19.job.platform.service.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class InvitationServiceImpl implements InvitationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvitationServiceImpl.class);

    private final InvitationRepository invitationRepository;
    private final UserService userService;
    private final OrganizationService organizationService;

    public InvitationServiceImpl(InvitationRepository invitationRepository, UserService userService, OrganizationService organizationService) {
        Assert.notNull(invitationRepository, "the invitationRepository cannot be null");
        Assert.notNull(userService, "the userService cannot be null");
        Assert.notNull(organizationService, "the organizationService cannot be null");
        this.invitationRepository = invitationRepository;
        this.userService = userService;
        this.organizationService = organizationService;
    }

    @Override
    public Invitation create(CreateInvitationParams params) {
        Assert.notNull(params, "The provided  params should not be null");
        LOGGER.info("Creating and saving an invitation for the provided params - {}", params);
        Optional<User> userOptional = userService.findById(params.getUserId());
        final User user = userOptional.orElseThrow(() -> new UserNotFoundException(params.getUserId()));

        Optional<Organization> organizationOptional = organizationService.findById(params.getOrganizationId());
        final Organization organization = organizationOptional.orElseThrow(() -> new OrganizationNotFoundException(params.getOrganizationId()));

        final Invitation transientInvitation = new Invitation(user, organization, params.getStatus());
        final Invitation persistentInvitation = invitationRepository.save(transientInvitation);
        LOGGER.info("Successfully created and saved an invitation for the provided params - {}", params);
        return persistentInvitation;
    }

    @Override
    public Invitation update(UpdateInvitationParams params) {
        Assert.notNull(params, "The provided params should not be null");
        LOGGER.info("Updating an invitation according to the provided params - {} ", params);
        Optional<User> userOptional = userService.findById(params.getUserId());
        final User user = userOptional.orElseThrow(() -> new UserNotFoundException(params.getUserId()));

        Optional<Organization> organizationOptional = organizationService.findById(params.getOrganizationId());
        final Organization organization = organizationOptional.orElseThrow(() -> new OrganizationNotFoundException(params.getOrganizationId()));

        Long invitationId = params.getInvitationId();
        Optional<Invitation> invitationOptional = invitationRepository.findById(invitationId);
        Invitation invitation = invitationOptional.orElseThrow(() -> new InvitationNotFoundException(invitationId));

        invitation.setStatus(params.getStatus());
        Invitation updatedInvitation = invitationRepository.save(invitation);
        LOGGER.info("Successfully updated an invitation according to the provided params - {},result - {} ", params, updatedInvitation);
        return updatedInvitation;
    }

    @Override
    public Optional<Invitation> findById(Long id) {
        Assert.notNull(id, "the invitation id cannot be null");
        LOGGER.info("Retrieving the invitation according to the provided id - {}", id);
        Optional<Invitation> invitationOptional = invitationRepository.findById(id);
        LOGGER.info("Successfully retrieved the invitation according to the provided id - {}, result - {}", id, invitationOptional);
        return invitationOptional;
    }

    @Override
    public Optional<Invitation> findByUserIdAndOrganizationId(Long userId, Long organizationId) {
        Assert.notNull(userId, "the userId cannot be null");
        Assert.notNull(organizationId, "the organizationId cannot be null");
        LOGGER.info("Retrieving the nvitation according to the provided userId - {} and organizationId - {}", userId, organizationId);
        Optional<Invitation> invitationOptional = invitationRepository.findByUserIdAndOrganizationId(userId, organizationId);
        LOGGER.info("Successfully retrieved the invitation according to the provided userId - {} and organizationId - {}, result - {}", userId, organizationId, invitationOptional);
        return invitationOptional;
    }
}
