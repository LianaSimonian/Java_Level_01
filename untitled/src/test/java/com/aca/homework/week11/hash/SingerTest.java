package com.aca.homework.week11.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SingerTest {
    private Singer testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new Singer("firstname", "lastname");
    }

    @Test
    public void testHshCodeFor2sameObject() {
        Singer singer = new Singer("firstname", "lastname");
        Assertions.assertEquals(singer.hashCode(), testSubject.hashCode());
    }

    @Test
    public void testHshCodeFor2DifferentObject() {
        Singer singer = new Singer("firstname1", "lastname1");
        Assertions.assertNotEquals(singer.hashCode(), testSubject.hashCode());
    }
}