package com.aca.homework.abstractphone;

public class Phone {
    private String imei;
    private Model model;

    public Phone(String imei, Model model) {
        this.imei = imei;
        this.model = model;
    }

    public String getImei() {
        return imei;
    }

    public Model getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "imei='" + imei + '\'' +
                ", model=" + model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o.getClass() == Phone.class) {
            return imei.equals(((Phone) o).imei) && model == ((Phone) o).model;
        }
        return false;
    }

    public void print() {
        System.out.println(model + ", " + "IMEI: " + imei);
    }
}
