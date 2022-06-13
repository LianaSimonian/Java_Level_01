package com.aca.homework.week18.website.facade.post.core;

import com.aca.homework.week18.website.entity.Image;

public interface ImageMapper {

    UploadImageResponseDto mapper(Image image);
}