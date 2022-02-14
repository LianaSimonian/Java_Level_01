package com.aca.homework.abstractphone;

public class PhoneService extends AbstractPhoneService {
    private Phone[] phones;
    private int size;
    private int counter;

    public PhoneService(int size) {
        this.size = size;
        phones = new Phone[size];
    }

    public Phone create(String imei, Model model) {
        Phone phone = new Phone(imei, model);
        if (counter > size) {
            System.out.println("phoneService is full");
            throw new RuntimeException();
        }
        phones[counter++] = phone;
        return phone;
    }

    public Phone getByImei(String imei) {
        if (counter == 0) {
            System.out.println("PhoneService is empty");
            throw new RuntimeException();
        }
        for (int i = 0; i < counter; i++) {
            if (phones[i].getImei().equals(imei))
                return phones[i];
        }
        return null;
    }

    public void printAll() {
        for (int i = 0; i < counter; i++) {
            phones[i].print();
        }
    }
}
