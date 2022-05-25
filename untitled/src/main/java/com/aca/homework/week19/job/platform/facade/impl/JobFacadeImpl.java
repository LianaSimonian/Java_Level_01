package com.aca.homework.week19.job.platform.facade.impl;

import com.aca.homework.week19.job.platform.dto.JobHireRequestDto;
import com.aca.homework.week19.job.platform.dto.JobHireResponseDto;
import com.aca.homework.week19.job.platform.dto.OrganizationDetailsDto;
import com.aca.homework.week19.job.platform.dto.UserDetailsDto;
import com.aca.homework.week19.job.platform.entity.*;
import com.aca.homework.week19.job.platform.facade.core.*;
import com.aca.homework.week19.job.platform.mapper.core.UserMapper;
import com.aca.homework.week19.job.platform.service.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class JobFacadeImpl implements JobFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvitationFacadeImpl.class);

    private final UserService userService;
    private final OrganizationService organizationService;
    private final UserOrganizationService userOrganizationService;
    private final InvitationService invitationService;
    private final InterviewService interviewService;
    private final UserMapper userMapper;

    public JobFacadeImpl(UserService userService, OrganizationService organizationService, UserOrganizationService userOrganizationService, InvitationService invitationService, InterviewService interviewService, UserMapper userMapper) {
        Assert.notNull(userService, "The provided userService should not be null");
        Assert.notNull(organizationService, "The provided organizationService should not be null");
        Assert.notNull(invitationService, "The provided invitationService should not be null");
        Assert.notNull(userOrganizationService, "The provided userOrganizationService should not be null");
        Assert.notNull(interviewService, "The provided interviewService should not be null");
        Assert.notNull(userMapper, "The provided userMapper should not be null");
        this.userService = userService;
        this.organizationService = organizationService;
        this.userOrganizationService = userOrganizationService;
        this.invitationService = invitationService;
        this.interviewService = interviewService;
        this.userMapper = userMapper;
    }

    @Override
    public JobHireResponseDto hire(JobHireRequestDto dto) {
        Assert.notNull(dto, "the job hire request dto param should not be null");
        LOGGER.info("hiring a user according to the job hire request dto - {}", dto);
        Long userId = dto.getUserId();
        Optional<User> userOptional = userService.findById(dto.getUserId());
        if (userOptional.isEmpty()) {
            return new JobHireResponseDto(List.of(String.format("the user with id %d not found", userId)));
        }

        Long organizationId = dto.getOrganizationId();
        Optional<Organization> organizationOptional = organizationService.findById(organizationId);
        if (organizationOptional.isEmpty()) {
            return new JobHireResponseDto(List.of(String.format("the organization with id %d not found", organizationId)));
        }

        Optional<Invitation> invitationOptional = invitationService.findByUserIdAndOrganizationId(userId, organizationId);
        if (invitationOptional.isEmpty()) {
            return new JobHireResponseDto(List.of(String.format("the user with id %d did not receive an invitation from organization with id % d", userId, organizationId)));
        }

        if (invitationOptional.get().getStatus() != InvitationStatusType.ACCEPTED) {
            return new JobHireResponseDto(List.of(String.format("the user with id %d did not accepted invitation from organization with id  %d", userId, organizationId)));
        }

        Optional<Interview> interviewOptional = interviewService.findByOrganizationIdAndUserId(organizationId, userId);
        if (interviewOptional.isEmpty()) {
            return new JobHireResponseDto(List.of(String.format("There was no interview with user having id %d by organization having id %d", userId, organizationId)));
        }

        Optional<UserOrganization> optionalUserOrganization = userOrganizationService.findByUserId(userId);
        if (optionalUserOrganization.isPresent()) {
            userOrganizationService.deleteByUserId(userId);
        }

        Interview updatedInterview = interviewService.update(new UpdateInterviewParams(InterviewStatusType.HIRE, interviewOptional.get().getId(), interviewOptional.get().getDateTime()));
        UserOrganization userOrganization = userOrganizationService.create(new CreateUserOrganizationParams(
                userId,
                organizationId,
                LocalDate.now()
        ));

        List<UserOrganization> userOrganizations = userOrganizationService.findAllByOrganizationId(organizationId);
        List<UserDetailsDto> employees = new LinkedList<>();
        userOrganizations.forEach(organizationUser -> {
            User tempUser = organizationUser.getUser();
            employees.add(new UserDetailsDto(
                    tempUser.getFirstName(),
                    tempUser.getSecondName(),
                    tempUser.getUsername(),
                    tempUser.getPassword(),
                    tempUser.isOpenForJobOffers()));
        });

        User user = userOptional.get();
        Organization organization = organizationOptional.get();
        JobHireResponseDto jobHireResponseDto = new JobHireResponseDto(userMapper.mapper(user),
                new OrganizationDetailsDto(organization.getName(), organization.getCreationDate(), employees));
        LOGGER.info("Successfully hired a user according to the job hire request dto - {}, jobHireResponseDto - {}", dto, jobHireResponseDto);
        return jobHireResponseDto;
    }
}