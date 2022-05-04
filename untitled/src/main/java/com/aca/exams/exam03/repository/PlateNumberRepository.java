package com.aca.exams.exam03.repository;

import com.aca.exams.exam03.entity.PlateNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlateNumberRepository extends JpaRepository<PlateNumber,Long> {
}
