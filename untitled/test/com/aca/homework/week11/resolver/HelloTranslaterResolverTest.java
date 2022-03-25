package com.aca.homework.week11.resolver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class HelloTranslaterResolverTest {
    private HelloTranslaterResolver testSubject;

    @BeforeEach
    public void setUp() {
        List<HelloTranslater> list =
                new LinkedList<>(List.of(new FrenchHelloTranslater(), new EnglishHelloTranslater(), new RussianHelloTranslater()));
        testSubject = new HelloTranslaterResolver(list);
    }

    @Test
    public void testResolveWithHelloMethodWhenLanguageIsEnglish() {
        Assertions.assertEquals(EnglishHelloTranslater.class, testSubject.resolve(LanguageType.ENGLISH).getClass());
        Assertions.assertEquals("hello", testSubject.resolve(LanguageType.ENGLISH).hello());
    }

    @Test
    public void testResolveWithHelloMethodWhenLanguageIsFrench() {
        Assertions.assertEquals(EnglishHelloTranslater.class, testSubject.resolve(LanguageType.ENGLISH).getClass());
        Assertions.assertEquals("Salut", testSubject.resolve(LanguageType.FRENCH).hello());
    }

    @Test
    public void testResolveWithHelloMethodWhenLanguageIsRussian() {
        Assertions.assertEquals(EnglishHelloTranslater.class, testSubject.resolve(LanguageType.ENGLISH).getClass());
        Assertions.assertEquals("Привет", testSubject.resolve(LanguageType.RUSSIAN).hello());
    }
}