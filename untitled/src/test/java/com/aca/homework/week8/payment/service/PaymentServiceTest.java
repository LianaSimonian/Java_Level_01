package com.aca.homework.week8.payment.service;

import com.aca.homework.week8.payment.service.PaymentService;
import com.aca.homework.week8.payment.service.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

class PaymentServiceTest {
    private PaymentService testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new PaymentService();
    }

    @Test
    public void testServiceAnnotation() {
        Annotation[] declaredAnnotations = testSubject.getClass().getDeclaredAnnotations();
        boolean haveServiceAnnotation = false;
        for (Annotation annotation : declaredAnnotations) {
            if (annotation.annotationType() == Service.class) {
                haveServiceAnnotation = true;
                break;
            }
        }
        Assertions.assertEquals(true, haveServiceAnnotation);
    }

    @Test
    public void testPaymentAmount() {
        Assertions.assertEquals(100, testSubject.pay(100).getPaymentAmount());
    }

    @Test
    public void testDuration() {
        Assertions.assertTrue(isInRangeFrom200To800(testSubject.pay(100).getProcessingTime()));
    }

    public static boolean isInRangeFrom200To800(long number) {
        return number >= 200 && number < 800;
    }
}