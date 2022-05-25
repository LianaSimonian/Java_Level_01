package com.aca.homework.week19.job.platform.service.core;

import com.aca.homework.week19.job.platform.entity.Interview;

import java.util.Optional;

public interface InterviewService {

    Interview create(CreateInterviewParams params);

    Interview update(UpdateInterviewParams params);

    Optional<Interview> findByOrganizationIdAndUserId(Long organizationId, Long userId);
}
