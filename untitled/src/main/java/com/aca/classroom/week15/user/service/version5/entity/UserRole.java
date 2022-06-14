package com.aca.classroom.week15.user.service.version5.entity;

import com.aca.homework.week15.sql.generate.Table;

import javax.persistence.*;

@Entity
@Table(name = "USER_ROLE")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "USER_ROLE_USER_ID"), nullable = false)
    private User user;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "TYPE", nullable = false, length = 50)
    private UserRoleType type;

    public UserRole() {
    }

    public UserRole(User user, UserRoleType type) {
        this.user = user;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public UserRoleType getType() {
        return type;
    }

    //adapter dp
    //base64
}//xozi girq skzbi 50 ej
//apiGataway d pattern apiGarAway inq@ servera vor Database chuni  u securityn henc iran kcenq heriqa
    //TCP
//dispatcherservlet defaulltov 1 hat servlet ka tomkati mej es anunov
//usernamepasswordautorizitetionfilter1,basicautorizetion filter2 2 filtrerri mijov a ancnum
//jainofresponsiblity
//basic autontication filtrer hat kar