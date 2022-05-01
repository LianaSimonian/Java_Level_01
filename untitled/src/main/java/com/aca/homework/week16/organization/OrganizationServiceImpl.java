package com.aca.homework.week16.organization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.Optional;

public class OrganizationServiceImpl implements OrganizationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationServiceImpl.class);
    private final OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        Assert.notNull(organizationRepository, "organization repository cannot be null");
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Organization create(final OrganizationCreateParams params) {
        Assert.notNull(params, "the params cannot be null");
        LOGGER.info("Creating organization for the provided params - {}", params);
        Organization organization = new Organization(params.getName(), params.getFullAddress());
        Organization savedOrganization = organizationRepository.save(organization);
        LOGGER.info("Successfully created a organization  for the provided params - {}", params);
        return savedOrganization;
    }

    @Override
    public Organization getById(final Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.info("Retrieving organization for the provided organization id - {}", id);
        final Optional<Organization> organizationOptional = organizationRepository.findById(id);

        if (organizationOptional.isEmpty()) {
            throw new OrganizationNotFoundException(id);
        }
        Organization organization = organizationOptional.get();
        LOGGER.info("Successfully retrieved the organization for the provided id - {}, result - {}", id, organization);

        return organization;
    }
}