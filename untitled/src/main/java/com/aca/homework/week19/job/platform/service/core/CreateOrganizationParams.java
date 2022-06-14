package com.aca.homework.week19.job.platform.service.core;

import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Objects;

public final class CreateOrganizationParams {

    private final String name;
    private final LocalDate creationDate;

    public CreateOrganizationParams(String name, LocalDate creationDate) {
        Assert.hasText(name, "The name should not be null or empty");
        Assert.notNull(creationDate, "The creationDate should not be null");
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
        if (!(o instanceof CreateOrganizationParams)) return false;

        CreateOrganizationParams that = (CreateOrganizationParams) o;

        return Objects.equals(name, that.name) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, creationDate);
    }

    @Override
    public String toString() {
        return "CreateOrganizationParams{" +
                "name='" + name + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
