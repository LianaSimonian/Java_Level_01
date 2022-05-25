package com.aca.homework.week19.job.platform.dto;

import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public final class JobHireResponseDto {

    private UserDetailsDto userDto;
    private OrganizationDetailsDto organizationDto;

    private List<String> errors;

    public JobHireResponseDto(List<String> errors) {
        Assert.notNull(errors, "the error list cannot be null");
        this.errors = errors;
    }

    public JobHireResponseDto(UserDetailsDto userDto, OrganizationDetailsDto organizationDto) {
        Assert.notNull(userDto, "The userDto cannot be null");
        Assert.notNull(organizationDto, "the organizationDto cannot be null");
        this.userDto = userDto;
        this.organizationDto = organizationDto;
    }

    public UserDetailsDto getUserDto() {
        return userDto;
    }

    public OrganizationDetailsDto getOrganizationDto() {
        return organizationDto;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "JobHireResponseDto{" +
                "userDto=" + userDto +
                ", organizationDto=" + organizationDto +
                ", errors=" + errors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobHireResponseDto)) return false;

        JobHireResponseDto that = (JobHireResponseDto) o;

        return Objects.equals(userDto, that.userDto) && Objects.equals(organizationDto, that.organizationDto) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userDto, organizationDto, errors);
    }
}