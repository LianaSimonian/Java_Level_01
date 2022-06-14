package com.aca.homework.week19.job.platform.facade.impl;

import com.aca.homework.week19.job.platform.dto.OrganizationDetailsDto;
import com.aca.homework.week19.job.platform.dto.OrganizationRegistrationRequestDto;
import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.mapper.core.OrganizationMapper;
import com.aca.homework.week19.job.platform.service.core.CreateOrganizationParams;
import com.aca.homework.week19.job.platform.service.core.OrganizationService;
import com.aca.homework.week19.job.platform.service.core.UserOrganizationService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class OrganizationFacadeImplTest {

    @InjectMocks
    private OrganizationFacadeImpl testSubject;

    @Mock
    private OrganizationService organizationService;

    @Mock
    private UserOrganizationService userOrganizationService;

    @Mock
    private OrganizationMapper organizationMapper;

    @Test
    public void testRegisterWhenDtoIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.register(null)).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("the organization registration request dto param should not be null");
    }


    @Test
    public void testRegisterWhenOrganizationAlreadyExists() {
        Mockito.when(organizationService.findByName("name")).thenReturn(Optional.of(new Organization("name", LocalDate.of(2020, 01, 02))));
        OrganizationDetailsDto detailsDto = testSubject.register(new OrganizationRegistrationRequestDto("name", LocalDate.of(2020, 01, 02)));
        Assertions.assertThat(detailsDto).isEqualTo(new OrganizationDetailsDto(List.of(String.format("organization with name %s already exists", "name"))));
        verify(organizationService).findByName("name");
        verifyNoMoreInteractions(organizationService);
    }

    @Test
    public void testRegister() {
        Mockito.when(organizationService.findByName("Krisp")).thenReturn(Optional.empty());
        final Organization organization = new Organization("Krisp", LocalDate.of(2017, 01, 01));
        Mockito.when(organizationService.create(new CreateOrganizationParams("Krisp", LocalDate.of(2017, 01, 01)))).thenReturn(organization);
        Mockito.when(organizationMapper.mapper(organization)).thenReturn(new OrganizationDetailsDto("Krisp", LocalDate.of(2017, 01, 01), Collections.emptyList()));
        OrganizationDetailsDto detailsDto = testSubject.register(new OrganizationRegistrationRequestDto("Krisp", LocalDate.of(2017, 01, 01)));
        Assertions.assertThat(detailsDto).isEqualTo(new OrganizationDetailsDto("Krisp", LocalDate.of(2017, 01, 01), Collections.emptyList()));
        verify(organizationService).findByName("Krisp");
        verify(organizationService).create(new CreateOrganizationParams("Krisp", LocalDate.of(2017, 01, 01)));
        verify(organizationMapper).mapper(organization);
        verifyNoMoreInteractions(organizationService, organizationMapper);
    }

    @Test
    public void testGetOrganizationDetailsWhenOrganizationIdIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.getOrganizationDetails(null)).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("the organizationId param should not be null");
    }

    @Test
    public void testGetOrganizationDetailsWhenOrganizationNotFound() {
        Mockito.when(organizationService.findById(1L)).thenReturn(Optional.empty());
        OrganizationDetailsDto detailsDto = testSubject.getOrganizationDetails(1L);
        Assertions.assertThat(detailsDto).isEqualTo(new OrganizationDetailsDto(List.of(String.format("organization with id %d not found", 1L))));
        verify(organizationService).findById(1L);
        verifyNoMoreInteractions(organizationService);
    }

    @Test
    public void testGetOrganizationDetails() {
        Organization organization = new Organization("name", LocalDate.of(2020, 02, 01));
        Mockito.when(organizationService.findById(1L)).thenReturn(Optional.of(organization));
        Mockito.when(userOrganizationService.findAllByOrganizationId(1L)).thenReturn(List.of());
        Mockito.when(organizationMapper.mapper(organization)).thenReturn(new OrganizationDetailsDto("name", LocalDate.of(2020, 02, 01), List.of()));
        Assertions.assertThat(testSubject.getOrganizationDetails(1L)).isEqualTo(new OrganizationDetailsDto("name", LocalDate.of(2020, 02, 01), List.of()));
        verify(organizationService).findById(1L);
        verify(userOrganizationService).findAllByOrganizationId(1L);
        verify(organizationMapper).mapper(organization);
        verifyNoMoreInteractions(organizationService, userOrganizationService, organizationMapper);
    }
}