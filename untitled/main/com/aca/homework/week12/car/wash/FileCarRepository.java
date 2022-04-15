package com.aca.homework.week12.car.wash;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileCarRepository implements CarRepository {

    private final String pathName;

    public FileCarRepository(String pathName) {
        this.pathName = pathName;
    }

    @Override
    public void save(Object data) {
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(pathName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found " + pathName, e);
        }

        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
        } catch (IOException e) {

            try {
                fileOutputStream.close();
            } catch (IOException ee) {
                ee.printStackTrace();
            }

            throw new RuntimeException(" I/O error occurs while writing stream header ,file path " + pathName, e);
        }

        try {
            objectOutputStream.writeObject(data);

        } catch (IOException e) {

            try {
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (IOException ee) {
                ee.printStackTrace();
            }

            throw new RuntimeException("failed to write ,file path " + pathName, e);
        }

        try {
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object load() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(pathName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found,file path " + pathName, e);
        }

        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("IOException thrown ,file path: " + pathName, e);
        }

        Map<String, Integer> dataMap = new HashMap<>();
        Entry<String, Integer> data = null;

        while (true) {
            try {
                data = (Entry<String, Integer>) objectInputStream.readObject();
                dataMap.put(data.getKey(), data.getValue());
            } catch (EOFException e) {
                try {
                    objectInputStream.close();
                } catch (IOException ee) {
                    throw new RuntimeException("file not closed,file path: " + pathName, ee);
                }
                return dataMap;
            } catch (IOException e) {
                throw new RuntimeException("failed to read,file path: " + pathName, e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Class not found", e);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return new File(pathName).length() == 0;
    }
}