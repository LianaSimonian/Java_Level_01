package com.aca.homework.week12.json;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ObjectJsonProcessorTest {

    @Test
    public void testProcess() {

        ObjectJsonProcessor testSubject = new ObjectJsonProcessor();
        String jsonUser = testSubject.process(new User("frosty_chebyshev", "Anton", "25"));
        Assertions.assertEquals("{\"username\": \"frosty_chebyshev\", \"name\": \"Anton\", \"age\": \"25\"}", jsonUser);
    }
}