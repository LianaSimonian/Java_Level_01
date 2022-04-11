package com.aca.homework.week11.resolver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnglishHelloTranslaterTest {
    private HelloTranslater testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new EnglishHelloTranslater();
    }

    @Test
    public void testType() {
        Assertions.assertEquals(LanguageType.ENGLISH, testSubject.type());
    }

    @Test
    public void testHello() {
        Assertions.assertEquals("hello", testSubject.hello());
    }
}