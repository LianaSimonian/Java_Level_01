package com.aca.homework.week11.resolver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RussianHelloTranslaterTest {
    private HelloTranslater testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new RussianHelloTranslater();
    }

    @Test
    public void testType() {
        Assertions.assertEquals(LanguageType.RUSSIAN, testSubject.type());
    }

    @Test
    public void testHello() {
        Assertions.assertEquals("Привет", testSubject.hello());
    }
}