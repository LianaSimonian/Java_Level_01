package com.aca.exam.exam3.service.core;

import com.aca.exam.exam3.entity.UserPlateNumber;
import org.springframework.stereotype.Service;

@Service
public interface UserPlateNumberService {

    UserPlateNumber create(PlateNumberCreationParams params);
}