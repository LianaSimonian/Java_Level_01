package com.aca.homework.week19.job.platform.dto;

import com.aca.homework.week19.job.platform.entity.InvitationStatusType;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public final class InvitationDetailsDto {

    private InvitationStatusType status;
    private OrganizationDetailsDto organizationDto;
    private UserDetailsDto userDto;

    private List<String> errors;

    public InvitationDetailsDto(List<String> errors) {
        this.errors = errors;
    }

    public InvitationDetailsDto(InvitationStatusType status, OrganizationDetailsDto organizationDto, UserDetailsDto userDto) {
        Assert.notNull(status, "The status should not be null");
        Assert.notNull(organizationDto, "The organizationDto should not be null");
        Assert.notNull(userDto, "the userDto should not be null");
        this.status = status;
        this.organizationDto = organizationDto;
        this.userDto = userDto;
    }

    public InvitationStatusType getStatus() {
        return status;
    }

    public OrganizationDetailsDto getOrganizationDto() {
        return organizationDto;
    }

    public UserDetailsDto getUserDto() {
        return userDto;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvitationDetailsDto)) return false;

        InvitationDetailsDto that = (InvitationDetailsDto) o;

        return Objects.equals(status, that.status) && Objects.equals(organizationDto, that.organizationDto) && Objects.equals(userDto, that.userDto) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, organizationDto, errors, userDto);
    }

    @Override
    public String toString() {
        return "InvitationDetailsDto{" +
                "status=" + status +
                ", organizationDto=" + organizationDto +
                ", userDto=" + userDto +
                ", errors=" + errors +
                '}';
    }
}
