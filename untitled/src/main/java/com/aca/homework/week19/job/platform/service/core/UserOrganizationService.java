package com.aca.homework.week19.job.platform.service.core;

import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.entity.UserOrganization;

import java.util.List;
import java.util.Optional;

public interface UserOrganizationService {

    UserOrganization create(CreateUserOrganizationParams params);

    List<UserOrganization> findAllByOrganizationId(Long id);

    Optional<UserOrganization> findByUserId(Long id);

    void deleteByUserId(Long id);
}
