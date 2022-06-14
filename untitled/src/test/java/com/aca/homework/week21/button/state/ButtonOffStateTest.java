package com.aca.homework.week21.button.state;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ButtonOffStateTest {

    private ButtonOffState testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = ButtonOffState.getInstance();
    }

    @Test
    public void testIsEnabled() {
        Assertions.assertFalse(testSubject.isEnabled());
    }

    @Test
    public void testColor() {
        Assertions.assertEquals(ColorType.BLUE, testSubject.color());
    }

    @Test
    public void testNextState() {
        Assertions.assertEquals(ButtonOnState.getInstance(), testSubject.nextState());
    }

}