package com.aca.homework.week21.post.service.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class CreatePostParamsTest {

    @Test
    public void testWhenCreationDateIsNull() {
        Assertions.assertThatThrownBy(() -> new CreatePostParams(null, "context", "name"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenContentIsNull() {
        Assertions.assertThatThrownBy(() -> new CreatePostParams(LocalDateTime.now(), null, "name"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenCreatedByIsNull() {
        Assertions.assertThatThrownBy(() -> new CreatePostParams(LocalDateTime.now(), "content", null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenContentIsEmpty() {
        Assertions.assertThatThrownBy(() -> new CreatePostParams(LocalDateTime.now(), "", "name"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenCreatedByIsEmpty() {
        Assertions.assertThatThrownBy(() -> new CreatePostParams(LocalDateTime.now(), "null", ""))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}