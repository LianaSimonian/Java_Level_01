package com.aca.homework.week9.donate;

import java.util.ArrayList;
import java.util.List;

public class AcaSmile<T extends Donatable> {
    // fields must be static
    private static double totalDonatedAmount;
    private static List<String> purchasedGoodsList = new ArrayList<>();

    public void buyWithDonation(T good) {
        System.out.println(good.toString() + " is bought");
        totalDonatedAmount += good.donationAmount();
        purchasedGoodsList.add(good.toString());
    }

    public static double getTotalDonatedAmount() {
        return totalDonatedAmount;
    }

    public static List<String> getPurchasedGoodsList() {
        return purchasedGoodsList;
    }

    //setTotalDonatedAmount()  getter needed only for testing
    public static void setTotalDonatedAmount(double totalDonatedAmount) {
        AcaSmile.totalDonatedAmount = totalDonatedAmount;
    }

}