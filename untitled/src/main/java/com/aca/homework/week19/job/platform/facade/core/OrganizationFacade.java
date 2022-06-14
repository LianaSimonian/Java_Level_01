package com.aca.homework.week19.job.platform.facade.core;


import com.aca.homework.week19.job.platform.dto.OrganizationDetailsDto;
import com.aca.homework.week19.job.platform.dto.OrganizationRegistrationRequestDto;

public interface OrganizationFacade {

    OrganizationDetailsDto register(OrganizationRegistrationRequestDto dto);

    OrganizationDetailsDto getOrganizationDetails(Long organizationId);
}