package com.aca.homework.week12.stopwatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DisplayTypeTest {
    @Test
    public void testDisplayFormatSecEndMillis() {
        DisplayType testSubject = DisplayType.SECONDS_AND_MILLIS;
        Assertions.assertEquals("123.456sec", testSubject.displayFormat(123456));
    }

    @Test
    public void testDisplayFormatSeconds() {
        DisplayType testSubject = DisplayType.SECONDS;
        Assertions.assertEquals("123sec", testSubject.displayFormat(123456));
    }

}