package com.aca.classroom.week15.user.service.version04.service.core;

import com.aca.classroom.week15.user.service.version04.entity.Diploma;
import org.springframework.stereotype.Service;

@Service
public interface DiplomaService {

    Diploma create(CreateDiplomaParams params);
}
//CRUD//DATA TRANSFER OBJECT disign pattern