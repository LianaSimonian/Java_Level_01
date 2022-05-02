package com.aca.exam.exam3.repository;

import com.aca.exam.exam3.entity.UserPlateNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlateNumberRepository extends JpaRepository<UserPlateNumber, Long> {

}
