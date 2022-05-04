package com.aca.exams.exam03.repository;

import com.aca.exams.exam03.entity.UserPlateNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPlateNumberRepository extends JpaRepository<UserPlateNumber, Long> {

}
