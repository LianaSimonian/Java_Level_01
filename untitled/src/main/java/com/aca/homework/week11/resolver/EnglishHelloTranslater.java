package com.aca.homework.week11.resolver;

public class EnglishHelloTranslater implements HelloTranslater {
    @Override
    public LanguageType type() {
        return LanguageType.ENGLISH;
    }

    @Override
    public String hello() {
        return "hello";
    }
}
