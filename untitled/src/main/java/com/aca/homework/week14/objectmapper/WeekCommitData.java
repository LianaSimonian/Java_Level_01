package com.aca.homework.week14.objectmapper;

public class WeekCommitData {

    private int total;
    private int week;
    private int[] days;

    public WeekCommitData() {

    }

    public WeekCommitData(int total, int week, int[] days) {
        this.total = total;
        this.week = week;
        this.days = days;
    }

    public int getTotal() {
        return total;
    }

    public int getWeek() {
        return week;
    }

    public int[] getDays() {
        return days;
    }
}