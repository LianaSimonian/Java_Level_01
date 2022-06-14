package com.aca.homework.week19.job.platform.dto;

import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public final class OrganizationDetailsDto {

    private String name;
    private LocalDate creationDate;
    private List<UserDetailsDto> employees;

    private List<String> errors;

    public OrganizationDetailsDto(List<String> errors) {
        Assert.notNull(errors, "the errors list cannot be null");
        this.errors = errors;
    }

    public OrganizationDetailsDto(String name, LocalDate creationDate, List<UserDetailsDto> employees) {
        Assert.hasText(name, "the name cannot be null or empty");
        Assert.notNull(creationDate, "The creationDate cannot be null");
        Assert.notNull(employees, "the employees list cannot be null");
        this.name = name;
        this.creationDate = creationDate;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public List<UserDetailsDto> getEmployees() {
        return employees;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganizationDetailsDto)) return false;

        OrganizationDetailsDto that = (OrganizationDetailsDto) o;

        return Objects.equals(name, that.name) && Objects.equals(creationDate, that.creationDate) && Objects.equals(employees, that.employees) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, creationDate, employees, errors);
    }

    @Override
    public String toString() {
        return "OrganizationDetailsDto{" +
                "name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", employees=" + employees +
                ", errors=" + errors +
                '}';
    }
}