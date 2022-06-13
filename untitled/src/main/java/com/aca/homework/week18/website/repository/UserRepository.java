package com.aca.homework.week18.website.repository;

import com.aca.homework.week18.website.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByPassword(String password);

    Optional<User> findByUsernameAndPassword(String username, String password);
}