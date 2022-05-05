package com.aca.classroom.week15.user.service.version4.service.core;

import com.aca.classroom.week15.user.service.version4.entity.Diploma;
import org.springframework.stereotype.Service;

@Service
public interface DiplomaService {

    Diploma create(CreateDiplomaParams params);
}
//CRAD//DATA TRANSFER OBJECT disign pattern