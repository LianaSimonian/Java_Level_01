package com.aca.homework.week19.job.platform.dto;

import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Objects;

public final class OrganizationRegistrationRequestDto {

    private final String name;
    private final LocalDate creationDate;

    public OrganizationRegistrationRequestDto(String name, LocalDate creationDate) {
        Assert.hasText(name, "The name cannot be null or empty");
        Assert.notNull(creationDate, "The creationDate cannot be null");
        this.name = name;
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganizationRegistrationRequestDto)) return false;

        OrganizationRegistrationRequestDto that = (OrganizationRegistrationRequestDto) o;

        return Objects.equals(name, that.name) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, creationDate);
    }

    @Override
    public String toString() {
        return "OrganizationRegistrationRequestDto{" +
                "name='" + name + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}