package com.aca.homework.week12.temperature;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        List<DailyTemperature> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(new DailyTemperature(random.nextInt(355) + 1, random.nextFloat(50)));
        }
        list.forEach(dailyTemperature -> {
            System.out.println(dailyTemperature);
        });


        DailyTemperatureFileItemWriter fileItemWriter = new DailyTemperatureFileItemWriter("C:\\Users\\user\\Desktop\\daily-temp-data.txt");
        for (DailyTemperature dailyTemperature : list) {
            fileItemWriter.write(dailyTemperature);
        }
        int fileLinesNumber = fileItemWriter.getNumberOfWritingItems();

        ItemReader<DailyTemperature> fileItemReader = new DailyTemperatureFileItemReader("C:\\Users\\user\\Desktop\\daily-temp-data.txt");
        List<DailyTemperature> dailyTemperatures = new LinkedList<>();
        DailyTemperature dailyTemperature = null;

        for (int i = 0; i < fileLinesNumber; i++) {
            fileItemReader.read(dailyTemperature);
            dailyTemperatures.add(dailyTemperature);
        }

        dailyTemperatures.forEach(item -> {
            System.out.println(item);
        });
    }
}