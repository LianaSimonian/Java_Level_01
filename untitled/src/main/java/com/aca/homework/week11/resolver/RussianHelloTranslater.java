package com.aca.homework.week11.resolver;

public class RussianHelloTranslater implements HelloTranslater {
    @Override
    public LanguageType type() {
        return LanguageType.RUSSIAN;
    }

    @Override
    public String hello() {
        return "Привет";
    }
}
