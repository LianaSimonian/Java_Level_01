package com.aca.homework.week9.taskreverse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class StringUtilsTest {
    @Test
    public void testReverseWhenArgumentIsNull() {
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                StringUtils.reverseUsingStringBuilder(null);
            }
        });
        Assertions.assertEquals("the string is null", illegalArgumentException.getMessage());
    }

    @Test
    public void testReverseWhenLengthIs1() {
        Assertions.assertEquals("A", StringUtils.reverseUsingStringBuilder("A"));
    }

    @Test
    public void testReverse() {
        Assertions.assertEquals("olleh", StringUtils.reverseUsingStringBuilder("hello"));
    }
}