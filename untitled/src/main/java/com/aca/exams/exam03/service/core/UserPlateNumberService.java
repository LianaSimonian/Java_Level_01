package com.aca.exams.exam03.service.core;

import com.aca.exams.exam03.entity.PlateNumber;
import com.aca.exams.exam03.entity.User;
import com.aca.exams.exam03.entity.UserPlateNumber;
import org.springframework.stereotype.Service;

@Service
public interface UserPlateNumberService {

    UserPlateNumber create(UserPlateNumberCreationParams params);

    User getByPlateNumber(PlateNumber plateNumber);
}