package com.aca.homework.week19.job.platform.service.core;

import com.aca.homework.week19.job.platform.entity.Organization;

import java.util.Optional;

public interface OrganizationService {

    Organization create(CreateOrganizationParams params);

    Optional<Organization> findById(Long id);
}
