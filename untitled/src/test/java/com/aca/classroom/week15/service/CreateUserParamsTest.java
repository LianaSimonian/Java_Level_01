package com.aca.classroom.week15.service;

import com.aca.classroom.week15.user.service.version04.service.core.CreateUserParams;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CreateUserParamsTest {


    @Test
    public void testNullFirstName() {
        Assertions.assertThatThrownBy(() -> new CreateUserParams("username", null, "second name", LocalDate.of(2013,02,12))).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testNullSecondName() {
        Assertions.assertThatThrownBy(() -> new CreateUserParams("username", "John", null,LocalDate.of(2013,02,12))).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testNullUsername() {
        Assertions.assertThatThrownBy(() -> new CreateUserParams(null, "John", "second name",LocalDate.of(2013,02,12))).isExactlyInstanceOf(IllegalArgumentException.class);
    }

}