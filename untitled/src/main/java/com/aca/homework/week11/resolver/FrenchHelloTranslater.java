package com.aca.homework.week11.resolver;

public class FrenchHelloTranslater implements HelloTranslater {
    @Override
    public LanguageType type() {
        return LanguageType.FRENCH;
    }

    @Override
    public String hello() {
        return "Salut";
    }
}
