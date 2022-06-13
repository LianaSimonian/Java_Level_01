package com.aca.homework.week18.website.facade.post.impl;

import com.aca.homework.week18.website.entity.Image;
import com.aca.homework.week18.website.facade.post.core.UploadImageResponseDto;
import com.aca.homework.week18.website.facade.post.core.ImageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageMapperImpl implements ImageMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageMapperImpl.class);

    @Override
    public UploadImageResponseDto mapper(Image image) {
        LOGGER.info("Mapping a image - {} to upload image response dto", image);
        final UploadImageResponseDto imageResponseDto = new UploadImageResponseDto(image.getBlobId(), image.getPost().getId());
        LOGGER.info("Successfully mapped a image - {} to upload image response dto ,result - {}", image, imageResponseDto);
        return imageResponseDto;
    }
}