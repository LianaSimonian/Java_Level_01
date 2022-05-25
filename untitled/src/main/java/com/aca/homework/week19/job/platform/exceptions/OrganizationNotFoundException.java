package com.aca.homework.week19.job.platform.exceptions;

public class OrganizationNotFoundException extends RuntimeException {

    public OrganizationNotFoundException(Long organizationId) {
        super(String.format("organization with id %d not found", organizationId));
    }
}