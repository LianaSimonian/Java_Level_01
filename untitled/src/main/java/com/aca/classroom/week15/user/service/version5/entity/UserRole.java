package com.aca.classroom.week15.user.service.version5.entity;

import com.aca.homework.week15.sql.generate.Table;

import javax.persistence.*;

@Entity
@Table(name = "USER_ROLE")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public UserRole() {

    }

    public UserRole(User user, UserRoleType type) {
        this.user = user;
        this.type = type;
    }

    @ManyToOne()
    @JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "USER_ROLE_USER_ID"), nullable = false)
    private User user;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "TYPE", nullable = false, length = 50)
    private UserRoleType type;

}
