package com.aca.homework.week11.map.performance;

import java.util.HashMap;
import java.util.Map;

@HighPerformance
public class HighPerformanceMapValueCountCalculator implements MapValueCountCalculator {
    private Map<String, Integer> stringsOccurrence = new HashMap<>(32, 0.5f);

    @Override
    public MinMaxOccurrence populateAndCalculate(int numberOfRandomStrings) {
        Randomizer randomizer = new Randomizer();
        for (int i = 0; i < numberOfRandomStrings; i++) {
            String randomString = randomizer.get8SizedString();
            if (stringsOccurrence.containsKey(randomString)) {
                stringsOccurrence.replace(randomString, stringsOccurrence.get(randomString) + 1);
            } else {
                stringsOccurrence.put(randomString, 1);
            }
        }
        return new MinMaxOccurrence(getMinValueEntry(), getMaxValueEntry());
    }

    public Map.Entry<String, Integer> getMaxValueEntry() {
        Map.Entry<String, Integer> maxEntry = stringsOccurrence.entrySet().iterator().next();
        for (Map.Entry<String, Integer> entry : stringsOccurrence.entrySet()) {
            if (entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return maxEntry;
    }

    public Map.Entry<String, Integer> getMinValueEntry() {
        Map.Entry<String, Integer> minEntry = stringsOccurrence.entrySet().iterator().next();
        for (Map.Entry<String, Integer> entry : stringsOccurrence.entrySet()) {
            if (entry.getValue() < minEntry.getValue()) {
                minEntry = entry;
            }
        }
        return minEntry;
    }
}