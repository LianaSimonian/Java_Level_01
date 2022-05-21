package com.aca.homework.week21.optional;

import org.springframework.util.Assert;

import java.util.Optional;
import java.util.function.Consumer;

public class OptionalMain {

    private final Consumer<Character> consumer;

    public OptionalMain(Consumer<Character> consumer) {
        Assert.notNull(consumer, "the consumer cannot be null");
        this.consumer = consumer;
    }

    void printFirstSymbol(Optional<String> stringOptional) {
        if (stringOptional.isEmpty())
            throw new IllegalArgumentException(String.format("the string param of printFirstSymbol() cannot be null"));
        char symbol = stringOptional.map(s -> s.length() < 2 ? ' ' : s.charAt(1)).orElse(' ');
        switch (symbol) {
            case ' ':
                return;
            default:
                consumer.accept(symbol);
        }
    }
}
