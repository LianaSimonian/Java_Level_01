package com.aca.homework.week7.car.tax;

public enum CarType {
    ELECTRIC {
        public String getAnnualTax(int carAge) {
            return "5$";
        }
    },
    HYBRID {
        public String getAnnualTax(int carAge) {
            return String.valueOf(5 * carAge) + "$";
        }
    };

    public abstract String getAnnualTax(int carAge);
}
