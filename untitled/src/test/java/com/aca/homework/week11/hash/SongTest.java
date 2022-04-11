package com.aca.homework.week11.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SongTest {
    private Song testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new Song(new Singer("firstname", "lastname"), "songname", 100L, 1.5F);
    }

    @Test
    public void testHashCodeFor2SameObject() {
        Song song1 = new Song(new Singer("firstname", "lastname"), "songname", 100L, 1.5F);
        Assertions.assertEquals(song1.hashCode(), testSubject.hashCode());
    }

    @Test
    public void testHashCodeFor2DifferentObject() {
        Song song1 = new Song(new Singer("firstname1", "lastname1"), "songname", 100L, 1.5F);
        Assertions.assertNotEquals(song1.hashCode(), testSubject.hashCode());
    }
}