package com.aca.homework.abstractphone;

public class Main {
    public static void main(String[] args) {
        PhoneService phoneService = new PhoneService(10);
        Phone phone1 = phoneService.create("351978946541895", Model.SAMSUNG);
        Phone phone2 = phoneService.create("45678974132187", Model.IPHONE);
        Phone phone3 = phoneService.create("04894100487866", Model.IPHONE);
        Phone phone4 = phoneService.create("99987741084444", Model.NOKIA);
        phoneService.printAll();
        System.out.println();

        String imei = "04894100487866";
        Phone phone = phoneService.getByImei(imei);
        if (phone != null) {
            phone.print();
        } else {
            System.out.println("don't find phone with" + imei + " IMEI");
        }
    }
}
