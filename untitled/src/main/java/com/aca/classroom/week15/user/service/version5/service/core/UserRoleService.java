package com.aca.classroom.week15.user.service.version5.service.core;

import com.aca.classroom.week15.user.service.version5.entity.UserRole;

import java.util.List;

public interface UserRoleService {

    UserRole getById(Long id);

    List<UserRole> getByUsername(String username);
}
