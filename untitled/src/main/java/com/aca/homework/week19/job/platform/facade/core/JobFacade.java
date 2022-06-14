package com.aca.homework.week19.job.platform.facade.core;

import com.aca.homework.week19.job.platform.dto.JobHireRequestDto;
import com.aca.homework.week19.job.platform.dto.JobHireResponseDto;

public interface JobFacade {

    JobHireResponseDto hire(JobHireRequestDto dto);
}
