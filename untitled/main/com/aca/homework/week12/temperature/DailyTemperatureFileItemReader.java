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
            //should I close() in catch block fileInputStream
            try {
                fileInputStream.close();
            } catch (IOException e1) {
                throw new RuntimeException("fileInputStream failed to close", e);
            }
            throw new RuntimeException("IOException thrown ,file path: " + filePath, e);
        }
        try {
            item = new DailyTemperature(objectInputStream.readInt(), objectInputStream.readFloat());
            objectInputStream.readChar();
            objectInputStream.close();
            fileInputStream.close();
        } catch (EOFException e) {
            ////should I close() in catch block fileInputStream,ObjectInputStream
            throw new RuntimeException(" EOFException thrown, file path " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("IOException thrown, file path " + filePath, e);
        }
    }
}