package com.aca.homework.week19.job.platform.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "INTERVIEWS")
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INTERVIEW_ID_SEQUENCE")
    @SequenceGenerator(name = "INTERVIEW_ID_SEQUENCE")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_INTERVIEWS_USER_ID_USERS_ID"), nullable = false)
    private User user;

    @Column(name = "datetime", nullable = false)
    private LocalDateTime dateTime;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private InterviewStatusType status;

    @ManyToOne
    @JoinColumn(name = "organization_id", foreignKey = @ForeignKey(name = "FK_INTERVIEWS_ORGANIZATION_ID_ORGANIZATIONS_ID"), nullable = false)
    private Organization organization;

    Interview() {
    }

    public Interview(User user, LocalDateTime dateTime, InterviewStatusType status, Organization organization) {
        this.user = user;
        this.dateTime = dateTime;
        this.status = status;
        this.organization = organization;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public InterviewStatusType getStatus() {
        return status;
    }

    public void setStatus(InterviewStatusType status) {
        this.status = status;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interview)) return false;

        Interview interview = (Interview) o;

        return Objects.equals(id, interview.id) && Objects.equals(user, interview.user) && Objects.equals(dateTime, interview.dateTime) && Objects.equals(status, interview.status) && Objects.equals(organization, interview.organization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, dateTime, status, organization);
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", user=" + user +
                ", dateTime=" + dateTime +
                ", status=" + status +
                ", organization=" + organization +
                '}';
    }
}