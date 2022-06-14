package com.aca.homework.week19.job.platform.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "USER_ORGANIZATION")
public class UserOrganization {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ORGANIZATION_ID_SEQUENCE")
    @SequenceGenerator(name = "USER_ORGANIZATION_ID_SEQUENCE")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_USER_ORGANIZATION_USER_ID_USERS_ID"), nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "organization_id", foreignKey = @ForeignKey(name = "FK_USER_ORGANIZATION_ORGANIZATION_ID_ORGANIZATION_ID"), nullable = false)
    private Organization organization;

    @Column(name = "start_date", unique = true, nullable = false)
    private LocalDate startDate;

    UserOrganization() {

    }

    public UserOrganization(User user, Organization organization, LocalDate startDate) {
        this.user = user;
        this.organization = organization;
        this.startDate = startDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserOrganization)) return false;

        UserOrganization that = (UserOrganization) o;

        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(organization, that.organization) && Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, organization, startDate);
    }

    @Override
    public String toString() {
        return "UserOrganization{" +
                "id=" + id +
                ", user=" + user +
                ", organization=" + organization +
                ", startDate=" + startDate +
                '}';
    }
}