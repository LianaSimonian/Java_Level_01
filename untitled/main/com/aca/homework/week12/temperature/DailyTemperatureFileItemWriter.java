package com.aca.homework.week12.temperature;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class DailyTemperatureFileItemWriter implements ItemWrite<DailyTemperature> {
    private final String filePath;
    private int numberOfWritingItems;

    public DailyTemperatureFileItemWriter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(DailyTemperature item) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not Found" + filePath, e);
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(" I/O error occurs while writing stream header ,file path" + filePath, e);
        }
        try {
            objectOutputStream.writeInt(item.getDayNumber());
            objectOutputStream.writeFloat(item.getDegree());
            objectOutputStream.write('\n');
            numberOfWritingItems++;
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException("I/O errors occur while writing to the underlying stream ,file path " + filePath, e);
        }
    }

    public int getNumberOfWritingItems() {
        return numberOfWritingItems;
    }
}