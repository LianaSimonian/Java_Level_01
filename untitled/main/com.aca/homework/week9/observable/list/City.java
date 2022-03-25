package com.aca.homework.week9.observable.list;

public class City {
    private ObservableList<Human> arrayObservableList = new ArrayObservableList<>();

    private City() {

    }

    public static City cityOf() {
        City city = new City();
        city.arrayObservableList.addListener(new ListChangeListener<Human>() {
            @Override
            public void onAdded(Human item) {
                System.out.println("A new joiner is: " + item.toString());
            }
        });
        city.arrayObservableList.addListener(new ListChangeListener<Human>() {
            @Override
            public void onAdded(Human item) {
                System.out.println("applause");
                wait500Millis();
                System.out.println("applause");
            }
        });
        return city;
    }

    private static void wait500Millis() {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 500) ;
    }
}