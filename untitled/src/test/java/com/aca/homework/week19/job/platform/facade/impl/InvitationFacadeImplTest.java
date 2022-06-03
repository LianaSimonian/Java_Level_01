package com.aca.homework.week19.job.platform.facade.impl;

import com.aca.homework.week19.job.platform.dto.*;
import com.aca.homework.week19.job.platform.entity.*;
import com.aca.homework.week19.job.platform.facade.core.InvitationFacade;
import com.aca.homework.week19.job.platform.mapper.core.OrganizationMapper;
import com.aca.homework.week19.job.platform.mapper.core.UserMapper;
import com.aca.homework.week19.job.platform.mapper.impl.OrganizationMapperImpl;
import com.aca.homework.week19.job.platform.mapper.impl.UserMapperImpl;
import com.aca.homework.week19.job.platform.service.core.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InvitationFacadeImplTest {

    private InvitationFacade testSubject;

    @Mock
    private UserService userService;

    @Mock
    private OrganizationService organizationService;

    @Mock
    private InvitationService invitationService;

    @Mock
    private UserOrganizationService userOrganizationService;

    @Mock
    private InterviewService interviewService;

    private UserMapper userMapper;

    private OrganizationMapper organizationMapper;

    @BeforeEach
    public void setUp() {
        userMapper = new UserMapperImpl();
        organizationMapper = new OrganizationMapperImpl();
        testSubject = new InvitationFacadeImpl(userService, organizationService, invitationService, userOrganizationService, interviewService, userMapper, organizationMapper);
    }

    @Test
    public void testSendInvitationWhenDtoIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.sendInvitation(null)).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("the invitation request dto param should not be null");
    }

    @Test
    public void testSendInvitationWhenUserNotFound() {
        Mockito.when(userService.findById(1l)).thenReturn(Optional.empty());
        InvitationDetailsDto detailsDto = testSubject.sendInvitation(new InvitationRequestDto(1L, 1L));
        Assertions.assertThat(detailsDto).isEqualTo(new InvitationDetailsDto(List.of(String.format("the user with id %d not found", 1L))));
        verify(userService).findById(1L);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testSendInvitationWhenOrganizationNotFound() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(new User("name", "secName", "username", "passowrd", true)));
        Mockito.when(organizationService.findById(1L)).thenReturn(Optional.empty());
        InvitationDetailsDto detailsDto = testSubject.sendInvitation(new InvitationRequestDto(1L, 1L));
        Assertions.assertThat(detailsDto).isEqualTo(new InvitationDetailsDto(List.of(String.format("the organization with id %d not found", 1L))));
        verify(userService).findById(1L);
        verify(organizationService).findById(1L);
        verifyNoMoreInteractions(userService, organizationService);
    }

    @Test
    public void testSendInvitationWhenUserIsNotOpenForJobOffers() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(new User("name", "secName", "username", "passowrd", false)));
        Mockito.when(organizationService.findById(1L)).thenReturn(Optional.of(new Organization("Krisp", LocalDate.of(2017, 01, 01))));
        InvitationDetailsDto detailsDto = testSubject.sendInvitation(new InvitationRequestDto(1L, 1L));
        Assertions.assertThat(detailsDto).isEqualTo(new InvitationDetailsDto(List.of(String.format("the HR can not send an invitation to the user with id %d ,because the user is not open to job offers", 1L))));
        verify(userService).findById(1L);
        verify(organizationService).findById(1L);
        verifyNoMoreInteractions(userService, organizationService);
    }

    @Test
    public void testSendInvitation() {
        final User user = new User("name", "secondName", "username", "password", true);
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(user));
        Organization organization = new Organization("Krisp", LocalDate.of(2017, 01, 01));
        Mockito.when(organizationService.findById(1L)).thenReturn(Optional.of(organization));
        Mockito.when(invitationService.create(new CreateInvitationParams(1L, 1L, InvitationStatusType.SENT))).thenReturn(new Invitation(user, organization, InvitationStatusType.SENT));
        Mockito.when(userOrganizationService.findAllByOrganizationId(1L)).thenReturn(List.of());
        final InvitationDetailsDto detailsDto = testSubject.sendInvitation(new InvitationRequestDto(1L, 1L));
        Assertions.assertThat(detailsDto).isEqualTo(new InvitationDetailsDto(InvitationStatusType.SENT,
                new OrganizationDetailsDto("Krisp", LocalDate.of(2017, 01, 01), List.of()),
                new UserDetailsDto("name", "secondName", "username", "password", true)));
        verify(userService).findById(1L);
        verify(organizationService).findById(1L);
        verify(invitationService).create(new CreateInvitationParams(1L, 1L, InvitationStatusType.SENT));
        verify(userOrganizationService).findAllByOrganizationId(1L);
        verifyNoMoreInteractions(userService, organizationService, invitationService, userOrganizationService);
    }

    @Test
    public void testAcceptInvitationWhenDtoIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.acceptInvitation(null)).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("the invitation accept dto param should not be null");
    }

    @Test
    public void testAcceptInvitationWhenUserNotFound() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.empty());
        InvitationDetailsDto detailsDto = testSubject.acceptInvitation(new InvitationAcceptDto(1L, 1L, LocalDateTime.now()));
        Assertions.assertThat(detailsDto).isEqualTo(new InvitationDetailsDto(List.of(String.format("the user with id %d not found", 1L))));
        verify(userService).findById(1L);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testAcceptInvitationWhenInvitationNotFound() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(new User("firstname", "secondName", "username", "password", true)));
        Mockito.when(invitationService.findById(1L)).thenReturn(Optional.empty());
        InvitationDetailsDto detailsDto = testSubject.acceptInvitation(new InvitationAcceptDto(1L, 1L, LocalDateTime.now()));
        Assertions.assertThat(detailsDto).isEqualTo(new InvitationDetailsDto(List.of(String.format("the invitation with id %d not found", 1L))));
        verify(userService).findById(1L);
        verify(invitationService).findById(1L);
        verifyNoMoreInteractions(userService, invitationService);
    }

    @Test
    public void testAcceptInvitationWhenInvitationDoesNotBelongThatUser() {
        User user = new User("firstname", "secondName", "username", "password", true);
        user.setId(1L);
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(user));
        User user1 = new User();
        user1.setId(2L);
        Mockito.when(invitationService.findById(1L)).thenReturn(Optional.of(new Invitation(user1, new Organization("Mentor Graphics", LocalDate.of(2010, 01, 01)), InvitationStatusType.SENT)));
        InvitationDetailsDto detailsDto = testSubject.acceptInvitation(new InvitationAcceptDto(1L, 1L, LocalDateTime.now()));
        Assertions.assertThat(detailsDto).isEqualTo(new InvitationDetailsDto(List.of(String.format("the user with id %d does not have invitation with id %d", 1L, 1L))));
        verify(userService).findById(1L);
        verify(invitationService).findById(1L);
        verifyNoMoreInteractions(userService, invitationService);
    }

    @Test
    public void testAcceptInvitation() {
        User user = new User("firstname", "secondName", "username", "password", true);
        user.setId(1L);
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(user));
        Organization organization = new Organization("Mentor Graphics", LocalDate.of(2010, 01, 01));
        organization.setId(1L);
        Mockito.when(invitationService.findById(1L)).thenReturn(Optional.of(new Invitation(user, organization, InvitationStatusType.SENT)));
        Mockito.when(invitationService.update(new UpdateInvitationParams(1L, 1L, 1L, InvitationStatusType.ACCEPTED))).thenReturn(new Invitation(user, organization, InvitationStatusType.ACCEPTED));
        LocalDate date = LocalDate.of(2022, 6, 30);
        LocalTime time = LocalTime.of(6, 30);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        Mockito.when(interviewService.create(new CreateInterviewParams(1L, dateTime, InterviewStatusType.INVITED, 1L))).thenReturn(new Interview(user, dateTime, InterviewStatusType.INVITED, organization));
        Mockito.when(userOrganizationService.findAllByOrganizationId(1L)).thenReturn(List.of());
        InvitationDetailsDto detailsDto = testSubject.acceptInvitation(new InvitationAcceptDto(1L, 1L, dateTime));
        Assertions.assertThat(detailsDto).isEqualTo(new InvitationDetailsDto(
                InvitationStatusType.ACCEPTED,
                new OrganizationDetailsDto("Mentor Graphics", LocalDate.of(2010, 01, 01),
                        List.of()),
                new UserDetailsDto("firstname", "secondName", "username", "password", true)));
        verify(userService).findById(1L);
        verify(invitationService).findById(1L);
        verify(invitationService).update(new UpdateInvitationParams(1L, 1L, 1L, InvitationStatusType.ACCEPTED));
        verify(interviewService).create(new CreateInterviewParams(1L, dateTime, InterviewStatusType.INVITED, 1L));
        verify(userOrganizationService).findAllByOrganizationId(1L);
        verifyNoMoreInteractions(userService, invitationService, interviewService, userOrganizationService);
    }

    @Test
    public void testRejectInvitationWhenDtoIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.rejectInvitation(null)).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("the invitation reject dto param should not be null");
    }

    @Test
    public void testRejectInvitationWhenUserNotFound() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.empty());
        InvitationDetailsDto detailsDto = testSubject.rejectInvitation(new InvitationRejectDto(1L, 1L));
        Assertions.assertThat(detailsDto).isEqualTo(new InvitationDetailsDto(List.of(String.format("the user with id %d not found", 1L))));
        verify(userService).findById(1L);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testRejectInvitationWhenInvitationNotFound() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(new User()));
        Mockito.when(invitationService.findById(1L)).thenReturn(Optional.empty());
        InvitationDetailsDto detailsDto = testSubject.rejectInvitation(new InvitationRejectDto(1L, 1L));
        Assertions.assertThat(detailsDto).isEqualTo(new InvitationDetailsDto(List.of(String.format("the invitation with id %d not found", 1L))));
        verify(userService).findById(1L);
        verify(invitationService).findById(1L);
        verifyNoMoreInteractions(userService, invitationService);
    }

    @Test
    public void testRejectInvitationWhenInvitationDoesNotBelongThatUser() {
        User user = new User("firstname", "secondName", "username", "password", true);
        user.setId(1L);
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(user));
        User user1 = new User();
        user1.setId(2L);
        Mockito.when(invitationService.findById(1L)).thenReturn(Optional.of(new Invitation(user1, new Organization("Mentor Graphics", LocalDate.of(2010, 01, 01)), InvitationStatusType.SENT)));
        InvitationDetailsDto detailsDto = testSubject.rejectInvitation(new InvitationRejectDto(1L, 1L));
        Assertions.assertThat(detailsDto).isEqualTo(new InvitationDetailsDto(List.of(String.format("the user with id %d does not have invitation with id %d", 1L, 1L))));
        verify(userService).findById(1L);
        verify(invitationService).findById(1L);
        verifyNoMoreInteractions(userService, invitationService);
    }

    @Test
    public void testRejectInvitation() {
        User user = new User("firstname", "secondName", "username", "password", true);
        user.setId(1L);
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(user));
        Organization organization = new Organization("Mentor Graphics", LocalDate.of(2010, 01, 01));
        organization.setId(1L);
        Mockito.when(invitationService.findById(1L)).thenReturn(Optional.of(new Invitation(user, organization, InvitationStatusType.SENT)));
        Mockito.when(invitationService.update(new UpdateInvitationParams(1L, 1L, 1L, InvitationStatusType.REJECTED))).thenReturn(new Invitation(user, organization, InvitationStatusType.REJECTED));
        Mockito.when(userOrganizationService.findAllByOrganizationId(1L)).thenReturn(List.of());
        InvitationDetailsDto detailsDto = testSubject.rejectInvitation(new InvitationRejectDto(1L, 1L));
        Assertions.assertThat(detailsDto).isEqualTo(new InvitationDetailsDto(
                InvitationStatusType.REJECTED,
                new OrganizationDetailsDto("Mentor Graphics", LocalDate.of(2010, 01, 01),
                        List.of()),
                new UserDetailsDto("firstname", "secondName", "username", "password", true)));
        verify(userService).findById(1L);
        verify(invitationService).findById(1L);
        verify(invitationService).update(new UpdateInvitationParams(1L, 1L, 1L, InvitationStatusType.REJECTED));
        verify(userOrganizationService).findAllByOrganizationId(1L);
        verifyNoMoreInteractions(userService, invitationService, userOrganizationService);
    }
}