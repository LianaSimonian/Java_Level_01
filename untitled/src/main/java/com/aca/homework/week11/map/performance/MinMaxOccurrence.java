package com.aca.homework.week11.map.performance;

import java.util.Map;

public class MinMaxOccurrence {
    private Map.Entry<String, Integer> minOccurrenceEntry;
    private Map.Entry<String, Integer> maxOccurrenceEntry;

    public MinMaxOccurrence(Map.Entry<String, Integer> minOccurrenceEntry, Map.Entry<String, Integer> maxOccurrenceEntry) {
        this.minOccurrenceEntry = minOccurrenceEntry;
        this.maxOccurrenceEntry = maxOccurrenceEntry;
    }

    public void print() {
        System.out.println(" min occurred key: " + minOccurrenceEntry.getKey() + ", min occurrence count:" + minOccurrenceEntry.getValue()
                + ", max occurred key: " + maxOccurrenceEntry.getKey() + ", max occurrence count: " + maxOccurrenceEntry.getValue());
    }
}
