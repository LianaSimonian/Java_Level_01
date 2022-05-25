package com.aca.homework.week19.job.platform.facade.impl;

import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.entity.UserOrganization;
import com.aca.homework.week19.job.platform.dto.OrganizationDetailsDto;
import com.aca.homework.week19.job.platform.facade.core.OrganizationFacade;
import com.aca.homework.week19.job.platform.dto.OrganizationRegistrationRequestDto;
import com.aca.homework.week19.job.platform.dto.UserDetailsDto;
import com.aca.homework.week19.job.platform.mapper.core.OrganizationMapper;
import com.aca.homework.week19.job.platform.service.core.CreateOrganizationParams;
import com.aca.homework.week19.job.platform.service.core.OrganizationService;
import com.aca.homework.week19.job.platform.service.core.UserOrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class OrganizationFacadeImpl implements OrganizationFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationFacadeImpl.class);

    private final OrganizationService organizationService;
    private final UserOrganizationService userOrganizationService;
    private final OrganizationMapper organizationMapper;

    public OrganizationFacadeImpl(OrganizationService organizationService, UserOrganizationService userOrganizationService, OrganizationMapper organizationMapper) {
        Assert.notNull(userOrganizationService, "The provided userOrganizationService should not be null");
        Assert.notNull(organizationService, "The provided organizationService should not be null");
        Assert.notNull(organizationMapper, "The provided organizationMapper should not be null");
        this.organizationService = organizationService;
        this.userOrganizationService = userOrganizationService;
        this.organizationMapper = organizationMapper;
    }

    @Override
    public OrganizationDetailsDto register(OrganizationRegistrationRequestDto dto) {
        Assert.notNull(dto, "the organization registration request dto param should not be null");
        LOGGER.info("registering the organization according to the provided request - {}", dto);
        Organization organization = organizationService.create(
                new CreateOrganizationParams(
                        dto.getName(),
                        dto.getCreationDate()));

        OrganizationDetailsDto organizationDetailsDto = organizationMapper.mapper(organization);
        LOGGER.info("Successfully registered the organization according to the provided request - {}, DetailsDto  - {} ", dto, organizationDetailsDto);
        return organizationDetailsDto;
    }

    @Override
    public OrganizationDetailsDto getOrganizationDetails(Long organizationId) {
        Assert.notNull(organizationId, "the organizationId param should not be null");
        LOGGER.info("Getting the organization details having id - {}", organizationId);
        Optional<Organization> organizationOptional = organizationService.findById(organizationId);
        if (organizationOptional.isEmpty()) {
            return new OrganizationDetailsDto(List.of(String.format("organization with id %d not found", organizationId)));
        }

        List<UserOrganization> userOrganizations= userOrganizationService.findAllByOrganizationId(organizationId);
        List<UserDetailsDto> userDetailsDtos = new LinkedList<>();
        userOrganizations.forEach(userOrganization -> {
            User user = userOrganization.getUser();
            userDetailsDtos.add(new UserDetailsDto(
                    user.getFirstName(),
                    user.getSecondName(),
                    user.getUsername(),
                    user.getPassword(),
                    user.isOpenForJobOffers()));
        });

        Organization organization = organizationOptional.get();
        organization.setEmployees(userDetailsDtos);
        OrganizationDetailsDto organizationDetailsDto = organizationMapper.mapper(organization);
        LOGGER.info("Successfully got the organization details having id - {}, DetailsDto - {}", organizationId, organizationDetailsDto);
        return organizationDetailsDto;
    }
}