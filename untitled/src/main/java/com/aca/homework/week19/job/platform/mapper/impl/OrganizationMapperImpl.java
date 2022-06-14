package com.aca.homework.week19.job.platform.mapper.impl;

import com.aca.homework.week19.job.platform.dto.OrganizationDetailsDto;
import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.mapper.core.OrganizationMapper;
import io.jsonwebtoken.lang.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

public class OrganizationMapperImpl implements OrganizationMapper {

    private final static Logger LOGGER = LoggerFactory.getLogger(OrganizationMapperImpl.class);

    @Override
    public OrganizationDetailsDto mapper(Organization organization) {
        Assert.notNull(organization, "the organization param cannot be null");
        LOGGER.info("Mapping an organization - {} to organization details dto", organization);
        OrganizationDetailsDto organizationDetailsDto = new OrganizationDetailsDto(
                organization.getName(),
                organization.getCreationDate(),
                organization.getEmployees());
        LOGGER.info("Successfully mapped an organization - {} to organization details dto ,result - {}", organization, organizationDetailsDto);
        return organizationDetailsDto;
    }
}
