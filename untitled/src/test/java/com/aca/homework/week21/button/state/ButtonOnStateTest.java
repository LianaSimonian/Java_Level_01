package com.aca.homework.week21.button.state;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ButtonOnStateTest {

    private ButtonOnState testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = ButtonOnState.getInstance();
    }

    @Test
    public void testIsEnabled() {
        Assertions.assertTrue(testSubject.isEnabled());
    }

    @Test
    public void testColor() {
        Assertions.assertEquals(ColorType.GREEN, testSubject.color());
    }

    @Test
    public void testNextState() {
        Assertions.assertEquals(ButtonOffState.getInstance(), testSubject.nextState());
    }
}