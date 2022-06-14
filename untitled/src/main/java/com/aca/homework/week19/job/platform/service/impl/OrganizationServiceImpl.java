package com.aca.homework.week19.job.platform.service.impl;

import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.repository.OrganizationRepository;
import com.aca.homework.week19.job.platform.service.core.CreateOrganizationParams;
import com.aca.homework.week19.job.platform.service.core.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    private final OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        Assert.notNull(organizationRepository, " the organizationRepository cannot be null");
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Organization create(CreateOrganizationParams params) {
        Assert.notNull(params, "The provided  params should not be null");
        LOGGER.info("Creating and saving an organization for the provided params - {}", params);
        final Organization transientOrganization = new Organization(params.getName(), params.getCreationDate());
        final Organization persistentOrganization = organizationRepository.save(transientOrganization);
        LOGGER.info("Successfully created end saved an organization  for the provided params - {},", params);
        return persistentOrganization;
    }

    @Override
    public Optional<Organization> findById(Long id) {
        Assert.notNull(id, "the organizationId should not be null");
        LOGGER.info("Retrieving organization for the provided id  - {}", id);
        final Optional<Organization> organizationOptional = organizationRepository.findById(id);
        LOGGER.info("Successfully retrieved the organization for the provided id - {}, result - {}", id, organizationOptional);
        return organizationOptional;
    }

    @Override
    public Optional<Organization> findByName(String name) {
        Assert.hasText(name, "the organization name  should not be null");
        LOGGER.info("Retrieving organization for the provided name  - {}", name);
        final Optional<Organization> organizationOptional = organizationRepository.findByName(name);
        LOGGER.info("Successfully retrieved the organization for the provided name - {}, result - {}", name, organizationOptional);
        return organizationOptional;
    }
}