package com.aca.exams.exam03.service.core;

public class PlateNumberCreationParams {

    private final String plateNumber;

    public PlateNumberCreationParams(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlateNumberCreationParams)) return false;

        PlateNumberCreationParams that = (PlateNumberCreationParams) o;

        return plateNumber != null ? plateNumber.equals(that.plateNumber) : that.plateNumber == null;
    }

    @Override
    public int hashCode() {
        return plateNumber != null ? plateNumber.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "NumberPlateServiceCreationParams{" +
                "plateNumber='" + plateNumber + '\'' +
                '}';
    }
}