package com.aca.homework.week19.job.platform.dto;

import org.springframework.util.Assert;

import java.util.Objects;

public final class InvitationRequestDto {

    private final Long userId;
    private final Long organizationId;

    public InvitationRequestDto(Long userId, Long organizationId) {
        Assert.notNull(userId, "The userId cannot be null");
        Assert.notNull(organizationId, "the organizationId cannot be null");
        this.userId = userId;
        this.organizationId = organizationId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvitationRequestDto)) return false;

        InvitationRequestDto that = (InvitationRequestDto) o;

        return Objects.equals(userId, that.userId) && Objects.equals(organizationId, that.organizationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, organizationId);
    }

    @Override
    public String toString() {
        return "InvitationRequestDto{" +
                "userId=" + userId +
                ", organizationId=" + organizationId +
                '}';
    }
}