package com.aca.homework.week7.car.tax;

import com.aca.homework.week7.car.tax.Car;
import com.aca.homework.week7.car.tax.CarType;

class
CarTypeTest {
    public static void main(String[] args) {
        Car car1 = new Car(2015, CarType.ELECTRIC);
        Car car2 = new Car(2010, CarType.HYBRID);

        System.out.println(car1.getType().getAnnualTax(car1.getCarAge()));
        System.out.println(car2.getType().getAnnualTax(car2.getCarAge()));
    }
}