package com.aca.exams.exam03.service.core;


import com.aca.exams.exam03.entity.PlateNumber;
import org.springframework.stereotype.Service;

@Service
public interface PlateNumberService {

    PlateNumber create(PlateNumberCreationParams params);

    PlateNumber getById(Long id);
}