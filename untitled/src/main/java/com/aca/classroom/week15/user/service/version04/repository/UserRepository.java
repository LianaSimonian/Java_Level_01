package com.aca.classroom.week15.user.service.version04.repository;

import com.aca.classroom.week15.user.service.version04.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long aLong);

    Optional<User> findByUsername(String username);
}