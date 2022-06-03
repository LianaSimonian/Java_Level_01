package com.aca.homework.week19.job.platform.entity;

import com.aca.homework.week19.job.platform.dto.UserDetailsDto;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ORGANIZATIONS")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORGANIZATION_ID_SEQUENCE")
    @SequenceGenerator(name = "ORGANIZATION_ID_SEQUENCE")
    private Long id;

    @Column(name = "name", unique = true, nullable = false, length = 15)
    private String name;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Transient
    private List<UserDetailsDto> employees;

    public Organization() {

    }

    public Organization(String name, LocalDate creationDate) {
        this.name = name;
        this.creationDate = creationDate;
        employees = Collections.emptyList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public List<UserDetailsDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<UserDetailsDto> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organization)) return false;

        Organization that = (Organization) o;

        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(creationDate, that.creationDate) && Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, creationDate, employees);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", employees=" + employees +
                '}';
    }
}