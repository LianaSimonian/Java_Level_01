package com.aca.classroom.week15.user.service.version3.service.core;

import com.aca.classroom.week15.user.service.version3.entity.Diploma;
import org.springframework.stereotype.Service;

@Service
public interface DiplomaService {

    Diploma create(CreateDiplomaParams params);
}
