package com.aca.homework.week12.temperature;

import java.io.*;

public class DailyTemperatureFileItemReader implements ItemReader<DailyTemperature> {
    private final String filePath;

    public DailyTemperatureFileItemReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void read(DailyTemperature item) {

        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("FileNotFoundException thrown,file path " + filePath, e);
        }
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("IOException thrown ,file path: " + filePath, e);
        }
        try {
            item = new DailyTemperature(objectInputStream.readInt(), objectInputStream.readFloat());
            objectInputStream.readChar();

        } catch (EOFException e) {
            throw new RuntimeException(" EOFException thrown, file path " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("IOException thrown, file path " + filePath, e);
        }
    }
}