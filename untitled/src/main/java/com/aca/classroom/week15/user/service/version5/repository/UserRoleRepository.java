package com.aca.classroom.week15.user.service.version5.repository;

import com.aca.classroom.week15.user.service.version5.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
