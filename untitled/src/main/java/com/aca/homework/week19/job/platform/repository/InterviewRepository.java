package com.aca.homework.week19.job.platform.repository;

import com.aca.homework.week19.job.platform.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {

    Optional<Interview> findByOrganizationIdAndUserId(Long organizationId, Long userId);
}
