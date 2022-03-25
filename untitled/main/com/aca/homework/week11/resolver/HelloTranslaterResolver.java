package com.aca.homework.week11.resolver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloTranslaterResolver {
    private final Map<LanguageType, HelloTranslater> helloTranslaters = new HashMap<>();

    HelloTranslaterResolver(List<HelloTranslater> list) {
        for (HelloTranslater helloTranslater : list) {
            helloTranslaters.put(helloTranslater.type(), helloTranslater);
        }
    }

    HelloTranslater resolve(LanguageType type) {
        return helloTranslaters.get(type);
    }

}