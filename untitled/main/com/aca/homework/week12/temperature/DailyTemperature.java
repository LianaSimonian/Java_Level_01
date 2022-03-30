package com.aca.homework.week12.temperature;

public class DailyTemperature {
    private final int dayNumber;
    private float degree;

    public DailyTemperature(int dayNumber, float degree) {
        this.dayNumber = dayNumber;
        if (dayNumber < 1 || dayNumber > 355) throw new InvalidYearDayNumberException(dayNumber);
        this.degree = degree;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public float getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        return "{dayNumber: " + dayNumber + ", degree: " + degree + "}";
    }
}