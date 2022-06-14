package com.aca.homework.week19.job.platform.facade.impl;

import com.aca.homework.week19.job.platform.dto.JobHireRequestDto;
import com.aca.homework.week19.job.platform.dto.JobHireResponseDto;
import com.aca.homework.week19.job.platform.dto.OrganizationDetailsDto;
import com.aca.homework.week19.job.platform.dto.UserDetailsDto;
import com.aca.homework.week19.job.platform.entity.*;
import com.aca.homework.week19.job.platform.mapper.core.OrganizationMapper;
import com.aca.homework.week19.job.platform.mapper.core.UserMapper;
import com.aca.homework.week19.job.platform.service.core.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class JobFacadeImplTest {

    @InjectMocks
    private JobFacadeImpl testSubject;

    @Mock
    private UserService userService;

    @Mock
    private OrganizationService organizationService;

    @Mock
    private UserOrganizationService userOrganizationService;

    @Mock
    private InvitationService invitationService;

    @Mock
    private InterviewService interviewService;

    @Mock
    private UserMapper userMapper;

    @Mock
    private OrganizationMapper organizationMapper;

    @Test
    public void testHireWhenDtoIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.hire(null)).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("the job hire request dto param should not be null");
    }

    @Test
    public void testHireWhenUserNotFound() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThat(testSubject.hire(new JobHireRequestDto(1L, 1L))).isEqualTo(new JobHireResponseDto(List.of(String.format("the user with id %d not found", 1L))));
        verify(userService).findById(1L);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testHireWhenOrganizationNotFound() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(new User()));
        Mockito.when(organizationService.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThat(testSubject.hire(new JobHireRequestDto(1L, 1L))).isEqualTo(new JobHireResponseDto(List.of(String.format("the organization with id %d not found", 1L))));
        verify(userService).findById(1L);
        verify(organizationService).findById(1L);
        verifyNoMoreInteractions(userService, organizationService);
    }

    @Test
    public void testHireWhenAppropriateInvitationNotFound() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(new User()));
        Mockito.when(organizationService.findById(1L)).thenReturn(Optional.of(new Organization()));
        Mockito.when(invitationService.findByUserIdAndOrganizationId(1L, 1L)).thenReturn(Optional.empty());
        Assertions.assertThat(testSubject.hire(new JobHireRequestDto(1L, 1L))).isEqualTo(new JobHireResponseDto(List.of(String.format("the user with id %d did not receive an invitation from organization with id % d", 1L, 1L))));
        verify(userService).findById(1L);
        verify(organizationService).findById(1L);
        verify(invitationService).findByUserIdAndOrganizationId(1L, 1L);
        verifyNoMoreInteractions(userService, organizationService, invitationService);
    }

    @Test
    public void testHireWhenInvitationNotAccepted() {
        User user = new User();
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(user));
        Organization organization = new Organization();
        Mockito.when(organizationService.findById(1L)).thenReturn(Optional.of(organization));
        Mockito.when(invitationService.findByUserIdAndOrganizationId(1L, 1L)).thenReturn(Optional.of(new Invitation(user, organization, InvitationStatusType.REJECTED)));
        Assertions.assertThat(testSubject.hire(new JobHireRequestDto(1L, 1L))).isEqualTo(new JobHireResponseDto(List.of(String.format("the user with id %d did not accepted invitation from organization with id  %d", 1L, 1L))));
        verify(userService).findById(1L);
        verify(organizationService).findById(1L);
        verify(invitationService).findByUserIdAndOrganizationId(1L, 1L);
        verifyNoMoreInteractions(userService, organizationService, invitationService);
    }

    @Test
    public void testHireWhenAppropriateInterviewNotFound() {
        User user = new User();
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(user));
        Organization organization = new Organization();
        Mockito.when(organizationService.findById(1L)).thenReturn(Optional.of(organization));
        Mockito.when(invitationService.findByUserIdAndOrganizationId(1L, 1L)).thenReturn(Optional.of(new Invitation(user, organization, InvitationStatusType.ACCEPTED)));
        Mockito.when(interviewService.findByOrganizationIdAndUserId(1L, 1L)).thenReturn(Optional.empty());
        Assertions.assertThat(testSubject.hire(new JobHireRequestDto(1L, 1L))).isEqualTo(new JobHireResponseDto(List.of(String.format("There was no interview with user having id %d by organization having id %d", 1L, 1L))));
        verify(userService).findById(1L);
        verify(organizationService).findById(1L);
        verify(invitationService).findByUserIdAndOrganizationId(1L, 1L);
        verify(interviewService).findByOrganizationIdAndUserId(1L, 1L);
        verifyNoMoreInteractions(userService, organizationService, invitationService, interviewService);
    }

    @Test
    public void testHire() {
        User user = new User("firstName", "secondName", "username", "password", true);
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(user));
        Organization organization = new Organization("name", LocalDate.of(2018, 11, 01));
        Mockito.when(organizationService.findById(1L)).thenReturn(Optional.of(organization));
        Mockito.when(invitationService.findByUserIdAndOrganizationId(1L, 1L)).thenReturn(Optional.of(new Invitation(user, organization, InvitationStatusType.ACCEPTED)));
        LocalDate date = LocalDate.of(2021, 01, 01);
        LocalTime time = LocalTime.of(6, 30);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        Interview interview = new Interview(user, dateTime, InterviewStatusType.INVITED, organization);
        interview.setId(1L);
        Mockito.when(interviewService.findByOrganizationIdAndUserId(1L, 1L)).thenReturn(Optional.of(interview));
        Mockito.when(userOrganizationService.findByUserId(1L)).thenReturn(Optional.empty());
        Mockito.when(interviewService.update(new UpdateInterviewParams(InterviewStatusType.HIRE, 1L, dateTime))).thenReturn(new Interview(user, dateTime, InterviewStatusType.HIRE, organization));
        Mockito.when(userOrganizationService.create(new CreateUserOrganizationParams(1L, 1L, LocalDate.now()))).thenReturn(new UserOrganization(user, organization, LocalDate.of(2021, 01, 01)));
        Mockito.when(userOrganizationService.findAllByOrganizationId(1L)).thenReturn(List.of());
        UserDetailsDto userDetailsDto = new UserDetailsDto("firstName", "secondName", "username", "password", true);
        Mockito.when(userMapper.mapper(user)).thenReturn(userDetailsDto);
        OrganizationDetailsDto organizationDetailsDto = new OrganizationDetailsDto("name", LocalDate.of(2020, 11, 01), List.of());
        Mockito.when(organizationMapper.mapper(organization)).thenReturn(organizationDetailsDto);
        JobHireResponseDto responseDto = testSubject.hire(new JobHireRequestDto(1L, 1L));
        Assertions.assertThat(responseDto).isEqualTo(new JobHireResponseDto(userDetailsDto, organizationDetailsDto));
        verify(userService).findById(1L);
        verify(organizationService).findById(1L);
        verify(invitationService).findByUserIdAndOrganizationId(1L, 1L);
        verify(interviewService).findByOrganizationIdAndUserId(1L, 1L);
        verify(userOrganizationService).findByUserId(1L);
        verify(interviewService).update(new UpdateInterviewParams(InterviewStatusType.HIRE, 1L, dateTime));
        verify(userOrganizationService).create(new CreateUserOrganizationParams(1L, 1L, LocalDate.now()));
        verify(userOrganizationService).findAllByOrganizationId(1L);
        verify(userMapper).mapper(user);
        verify(organizationMapper).mapper(organization);
        verifyNoMoreInteractions(
                userService,
                organizationService,
                invitationService,
                interviewService,
                userOrganizationService,
                userMapper,
                organizationMapper);
    }
}