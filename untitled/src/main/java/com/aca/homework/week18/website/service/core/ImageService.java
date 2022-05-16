package com.aca.homework.week18.website.service.core;

import com.aca.homework.week18.website.entity.Image;

import java.util.List;
import java.util.Optional;

public interface ImageService {

    Image create(CreateImageParams params);

    Optional<Image> findById(Long id);

    List<Image> findAllByPostId(Long id);
}
