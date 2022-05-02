package com.aca.exam.exam3.repository;

import com.aca.exam.exam3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}