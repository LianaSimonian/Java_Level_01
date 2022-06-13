package com.aca.homework.week18.website.repository;

import com.aca.homework.week18.website.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUserId(Long id);
}