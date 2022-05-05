package com.aca.classroom.week15.user.service.version4.repository;

import com.aca.classroom.week15.user.service.version4.entity.Diploma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiplomaRepository extends JpaRepository<Diploma, Long> {

}
//CRAD
//FRAMWORCK lib
//JPQL//@Query