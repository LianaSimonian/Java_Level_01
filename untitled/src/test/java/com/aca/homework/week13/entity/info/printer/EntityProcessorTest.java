package com.aca.homework.week13.entity.info.printer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

class EntityProcessorTest {

    @Test
    public void testPrintInfoWhenObjectIsAnnotatedWithEntity() {
        EntityProcessor testSubject = new EntityProcessor(new Consumer<String>() {
            @Override
            public void accept(String s) {
                Assertions.assertEquals("table name is: PRODUCT, id is 10, NAME is box", s);
            }
        });
        testSubject.printInfo(new Product(10L, "box"));
    }

    @Test
    public void testPrintInfoWhenObjectIsNotAnnotatedWithEntity() {
        EntityProcessor testSubject = new EntityProcessor((s) -> {
            Assertions.assertEquals("", s);
        });
        testSubject.printInfo("Hello");
    }
}