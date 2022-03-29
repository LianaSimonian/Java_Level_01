package com.aca.homework.week10.object.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServletRequestObjectFactoryTest {
    private ObjectFactory<ServletRequest> subject;

    @BeforeEach
    public void setUp() {
        subject = new ServletRequestObjectFactory<>();
    }

    @Test
    public void testSingleGetObject() {
        subject.getObject();
        Assertions.assertNotNull(subject.getObject());
    }

    @Test
    public void testGet2Objects() {
        ServletRequest object1 = subject.getObject();
        ServletRequest object2 = subject.getObject();
        Assertions.assertNotEquals(object1, object2);
    }

    @Test
    public void testGet3Objects() {
        ServletRequest object1 = subject.getObject();
        ServletRequest object2 = subject.getObject();
        ServletRequest object3 = subject.getObject();
        Assertions.assertNotEquals(object1, object2);
        Assertions.assertNotEquals(object2, object3);
    }
}