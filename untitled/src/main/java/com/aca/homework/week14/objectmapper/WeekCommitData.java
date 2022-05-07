package com.aca.homework.week14.objectmapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeekCommitData {

    @JsonProperty("jsonFieldTotal")
    private Integer total;
    @JsonProperty("jsonFieldWeek")
    private Integer week;
    @JsonProperty("jsonFieldDays")
    private Integer[] days;

    public WeekCommitData() {

    }

    public WeekCommitData(Integer total, Integer week, Integer[] days) {
        this.total = total;
        this.week = week;
        this.days = days;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getWeek() {
        return week;
    }

    public Integer[] getDays() {
        return days;
    }
}