package com.aca.classroom.week15.user.service.version5.service;

import com.aca.classroom.week15.user.service.version5.entity.UserRole;

import java.util.List;

public interface UserRoleService {
    UserRole getyid(Long id);

    List<UserRole> getByUsername(String username);
}
