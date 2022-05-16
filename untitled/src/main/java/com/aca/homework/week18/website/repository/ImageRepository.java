package com.aca.homework.week18.website.repository;

import com.aca.homework.week18.website.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findAllByPostId(Long id);
}
