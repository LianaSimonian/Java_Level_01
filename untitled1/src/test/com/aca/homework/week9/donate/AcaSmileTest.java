package com.aca.homework.week9.donate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class AcaSmileTest {
    private static int counter;
    private AcaSmile<Donatable> acaSmile;

    @BeforeEach
    public void setUp() {
        if (counter != 0) {
            AcaSmile.setTotalDonatedAmount(0);
            AcaSmile.getPurchasedGoodsList().clear();
        }
        acaSmile = new AcaSmile<>();
        counter++;
    }

    @Test
    public void testWhenNothingIsBought() {
        Assertions.assertEquals(0.0, AcaSmile.getTotalDonatedAmount());
    }

    @Test
    public void testWhenOneSmartphoneIsBought() {
        acaSmile.buyWithDonation(new Smartphone(100));
        Assertions.assertEquals(5, AcaSmile.getTotalDonatedAmount());
    }

    @Test
    public void testWhenOneSmartphoneAndOneWatchIsBought() {
        acaSmile.buyWithDonation(new Smartphone(100));
        acaSmile.buyWithDonation(new Watch(200));
        Assertions.assertEquals(15, AcaSmile.getTotalDonatedAmount());
    }

    @Test
    public void testWhenOneSmartphoneOneWatchAndOneSmartWatchIsBought() {
        acaSmile.buyWithDonation(new Smartphone(100));
        acaSmile.buyWithDonation(new Watch(200));
        acaSmile.buyWithDonation(new SmartWatch(1000));
        Assertions.assertEquals(65, AcaSmile.getTotalDonatedAmount());
    }

    @Test
    public void testGetPurchasedGoodsList() {
        acaSmile.buyWithDonation(new Smartphone(100));
        acaSmile.buyWithDonation(new Watch(200));
        acaSmile.buyWithDonation(new SmartWatch(1000));
        List<String> list = AcaSmile.getPurchasedGoodsList();
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("SmartPhone: price=100.0", list.get(0));
        Assertions.assertEquals("Watch: price=200.0", list.get(1));
        Assertions.assertEquals("SmartWatch: price=1000.0", list.get(2));
    }
}