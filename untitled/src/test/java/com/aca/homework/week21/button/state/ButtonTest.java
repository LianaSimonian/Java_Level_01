package com.aca.homework.week21.button.state;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ButtonTest {

    private Button testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new Button(ButtonOnState.getInstance());
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
    public void testSwitchState() {
        testSubject.switchState();
        Assertions.assertEquals(ButtonOffState.getInstance(), testSubject.getState());
    }

    @Test
    public void testGetState() {
        Assertions.assertEquals(ButtonOnState.getInstance(), testSubject.getState());
    }
}