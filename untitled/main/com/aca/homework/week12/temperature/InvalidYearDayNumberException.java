package com.aca.homework.week12.temperature;

public class InvalidYearDayNumberException extends RuntimeException {
    InvalidYearDayNumberException(int dayNumber) {
        super(dayNumber + "out of range from [1 , 355] ");
    }
}