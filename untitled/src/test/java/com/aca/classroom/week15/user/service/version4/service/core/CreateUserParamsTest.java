package com.aca.classroom.week15.user.service.version4.service.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class CreateUserParamsTest {

    @Test
    public void testNullFirstName() {
        Assertions.assertThatThrownBy(() -> new CreateUserParams("username", null, "second name"));
    }

    @Test
    public void testNullSecondName() {
        Assertions.assertThatThrownBy(() -> new CreateUserParams("username", "John", null));
    }

    @Test
    public void testNullUsername() {
        Assertions.assertThatThrownBy(() -> new CreateUserParams(null, "John", "second name"));
    }
}