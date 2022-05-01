package com.aca.homework.week16.organization;

import org.springframework.stereotype.Service;

@Service
public interface OrganizationService {

    Organization create(final OrganizationCreateParams params);

    Organization getById(final Long id);
}