package com.aca.homework.week19.job.platform.facade.impl;

import com.aca.homework.week19.job.platform.dto.*;
import com.aca.homework.week19.job.platform.entity.*;
import com.aca.homework.week19.job.platform.facade.core.*;
import com.aca.homework.week19.job.platform.mapper.core.UserMapper;
import com.aca.homework.week19.job.platform.service.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class InvitationFacadeImpl implements InvitationFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvitationFacadeImpl.class);

    private final UserService userService;
    private final OrganizationService organizationService;
    private final InvitationService invitationService;
    private final UserOrganizationService userOrganizationService;
    private final InterviewService interviewService;
    private final UserMapper userMapper;

    public InvitationFacadeImpl(UserService userService, OrganizationService organizationService, InvitationService invitationService, UserOrganizationService userOrganizationService, InterviewService interviewService, UserMapper userMapper) {
        Assert.notNull(userService, "The provided userService should not be null");
        Assert.notNull(organizationService, "The provided organizationService should not be null");
        Assert.notNull(invitationService, "The provided invitationService should not be null");
        Assert.notNull(userOrganizationService, "The provided userOrganizationService should not be null");
        Assert.notNull(interviewService, "The provided interviewService should not be null");
        Assert.notNull(userMapper, "The provided userMapper should not be null");
        this.userService = userService;
        this.organizationService = organizationService;
        this.invitationService = invitationService;
        this.userOrganizationService = userOrganizationService;
        this.interviewService = interviewService;
        this.userMapper = userMapper;
    }

    @Override
    public InvitationDetailsDto sendInvitation(InvitationRequestDto dto) {
        Assert.notNull(dto, "the invitation request dto param should not be null");
        LOGGER.info("sending the invitation according to the provided request - {}", dto);
        Long userId = dto.getUserId();
        Optional<User> userOptional = userService.findById(userId);
        if (userOptional.isEmpty()) {
            return new InvitationDetailsDto(List.of(String.format("the user with id %d not found", userId)));
        }

        Long organizationId = dto.getOrganizationId();
        Optional<Organization> organizationOptional = organizationService.findById(organizationId);
        if (organizationOptional.isEmpty()) {
            return new InvitationDetailsDto(List.of(String.format("the organization with id %d not found", organizationId)));
        }

        User user = userOptional.get();
        if (!user.isOpenForJobOffers()) {
            return new InvitationDetailsDto(List.of(String.format("the HR can not send an invitation to the user with id %d ,because the user is not open to job offers")));
        }

        Invitation invitation = invitationService.create(new CreateInvitationParams(
                userId,
                organizationId,
                InvitationStatusType.SENT
        ));

        List<UserOrganization> userOrganizations = userOrganizationService.findAllByOrganizationId(organizationId);
        List<UserDetailsDto> employees = new LinkedList<>();
        userOrganizations.forEach(userOrganization -> {
            User tempUser = userOrganization.getUser();
            employees.add(new UserDetailsDto(
                    tempUser.getFirstName(),
                    tempUser.getSecondName(),
                    tempUser.getUsername(),
                    tempUser.getPassword(),
                    tempUser.isOpenForJobOffers()));
        });

        Organization organization = organizationOptional.get();
        InvitationDetailsDto invitationDetailsDto = new InvitationDetailsDto(
                invitation.getStatus(),
                new OrganizationDetailsDto(organization.getName(), organization.getCreationDate(), employees
                ), userMapper.mapper(user));
        LOGGER.info("Successfully sent the invitation according to the provided request - {} , detailsDto- {}", dto, invitationDetailsDto);
        return invitationDetailsDto;
    }

    @Override
    public InvitationDetailsDto acceptInvitation(InvitationAcceptDto dto) {
        Assert.notNull(dto, "the invitation request dto param should not be null");
        LOGGER.info("accepting the invitation according to the provided request - {}", dto);
        Long userId = dto.getUserId();
        Optional<User> userOptional = userService.findById(userId);
        if (userOptional.isEmpty()) {
            return new InvitationDetailsDto(List.of(String.format("the user with id %d not found", userId)));
        }

        Long invitationId = dto.getInvitationId();
        Optional<Invitation> invitationOptional = invitationService.findById(invitationId);
        if (invitationOptional.isEmpty()) {
            return new InvitationDetailsDto(List.of(String.format("the invitation with id %d not found", invitationId)));
        }

        Invitation invitation = invitationOptional.get();
        if (!invitation.getUser().getId().equals(dto.getUserId())) {
            return new InvitationDetailsDto(List.of(String.format("the user with id %d does not have invitation with id %d", userId, invitationId)));
        }

        Long organizationId = invitation.getOrganization().getId();
        Invitation updatedInvitation = invitationService.update(new UpdateInvitationParams(
                invitationId,
                userId,
                organizationId,
                InvitationStatusType.ACCEPTED
        ));
        Interview interview = interviewService.create(new CreateInterviewParams(userId, LocalDateTime.now(), InterviewStatusType.INVITED, organizationId));
        List<UserOrganization> userOrganizations = userOrganizationService.findAllByOrganizationId(organizationId);
        List<UserDetailsDto> employees = new LinkedList<>();
        userOrganizations.forEach(userOrganization -> {
            User user = userOrganization.getUser();
            employees.add(new UserDetailsDto(
                    user.getFirstName(),
                    user.getSecondName(),
                    user.getUsername(),
                    user.getPassword(),
                    user.isOpenForJobOffers()));
        });

        User user = userOptional.get();
        Organization organization = updatedInvitation.getOrganization();
        InvitationDetailsDto invitationDetailsDto = new InvitationDetailsDto(updatedInvitation.getStatus(),
                new OrganizationDetailsDto(
                        organization.getName(),
                        organization.getCreationDate(), employees),
                userMapper.mapper(user));
        LOGGER.info("Successfully accepted the invitation according to the provided request - {} , detailsDto- {}", dto, invitationDetailsDto);
        return invitationDetailsDto;
    }

    @Override
    public InvitationDetailsDto rejectInvitation(InvitationRejectDto dto) {
        Assert.notNull(dto, "the invitation request dto param should not be null");
        LOGGER.info("rejecting the invitation according to the provided request - {}", dto);
        Long userId = dto.getUserId();
        Optional<User> userOptional = userService.findById(userId);
        if (userOptional.isEmpty()) {
            return new InvitationDetailsDto(List.of(String.format("the user with id %d not found", userId)));
        }

        Long invitationId = dto.getInvitationId();
        Optional<Invitation> invitationOptional = invitationService.findById(invitationId);
        if (invitationOptional.isEmpty()) {
            return new InvitationDetailsDto(List.of(String.format("the invitation with id %d not found", invitationId)));
        }

        Invitation invitation = invitationOptional.get();
        if (!invitation.getUser().getId().equals(dto.getUserId())) {
            return new InvitationDetailsDto(List.of(String.format("the user with id %d does not have invitation with id %d", userId, invitationId)));
        }

        Long organizationId = invitation.getOrganization().getId();
        Invitation updatedInvitation = invitationService.update(new UpdateInvitationParams(
                invitationId,
                userId,
                organizationId,
                InvitationStatusType.REJECTED
        ));

        List<UserOrganization> userOrganizations = userOrganizationService.findAllByOrganizationId(organizationId);
        List<UserDetailsDto> employees = new LinkedList<>();
        userOrganizations.forEach(userOrganization -> {
            User user = userOrganization.getUser();
            employees.add(new UserDetailsDto(
                    user.getFirstName(),
                    user.getSecondName(),
                    user.getUsername(),
                    user.getPassword(),
                    user.isOpenForJobOffers()));
        });

        User user = userOptional.get();
        Organization organization = invitation.getOrganization();
        InvitationDetailsDto invitationDetailsDto = new InvitationDetailsDto(updatedInvitation.getStatus(),
                new OrganizationDetailsDto(
                        organization.getName(),
                        organization.getCreationDate(), employees),
                userMapper.mapper(user));
        LOGGER.info("Successfully rejected the invitation according to the provided request - {} , detailsDto- {}", dto, invitationDetailsDto);
        return invitationDetailsDto;
    }
}