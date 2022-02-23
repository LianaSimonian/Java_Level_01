package com.aca.homework.week7.car.tax;

public enum CarType {
    ELECTRIC(2015),
    HYBRID(2010);

    private int modelYear;
    public static int calendarYear = 2022;

    CarType(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getAnnualTax() {
        if (this == ELECTRIC) return "5$";
        else
            return String.valueOf(5 * getCarAge()) + "$";
    }

    public int getCarAge() {
        return calendarYear - modelYear;
    }
}
