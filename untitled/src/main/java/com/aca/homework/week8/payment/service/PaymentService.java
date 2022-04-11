package com.aca.homework.week8.payment.service;

import java.util.Random;

@Service
public class PaymentService {
    public PaymentResult pay(int money) {
        int low = 200;
        int high = 800;
        int millisecondsOfWait = generateRandomIntBetween(low, high);
        waitForSomeMilliseconds(millisecondsOfWait);
        System.out.println("the payment is done " + money);
        return new PaymentResult(money, millisecondsOfWait);
    }

    private static void waitForSomeMilliseconds(int milliseconds) {
        long startMillis = System.currentTimeMillis();
        while (System.currentTimeMillis() - startMillis < milliseconds) ;

    }

    private static int generateRandomIntBetween(int low, int high) {
        return new Random().nextInt(high - low) + low;
    }
}
