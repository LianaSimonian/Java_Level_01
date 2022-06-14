package com.aca.homework.week19.job.platform.mapper.core;

import com.aca.homework.week19.job.platform.dto.OrganizationDetailsDto;
import com.aca.homework.week19.job.platform.entity.Organization;

public interface OrganizationMapper {

    OrganizationDetailsDto mapper(Organization organization);
}
