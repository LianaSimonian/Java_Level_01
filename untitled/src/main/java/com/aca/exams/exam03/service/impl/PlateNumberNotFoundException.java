package com.aca.exams.exam03.service.impl;

public class PlateNumberNotFoundException extends RuntimeException {

    public PlateNumberNotFoundException(Long id) {
        super(String.format("plateNumber with the id %d not found", id));
    }
}