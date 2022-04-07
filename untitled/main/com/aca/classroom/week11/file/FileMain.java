package com.aca.classroom.week11.file;

import java.io.*;

public class FileMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final String fileName = "D:\\Users\\user\\IdeaProjects\\aca\\Java_Level_01\\untitled\\main\\com\\aca\\classroom\\week11\\file\\file.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);

        fileOutputStream.write(123456789);
        fileOutputStream.write('1');
        fileOutputStream.write('2');
        fileOutputStream.write('3');
        fileOutputStream.write('4');
        fileOutputStream.write('5');
        fileOutputStream.write('6');
        fileOutputStream.write('7');
        fileOutputStream.write('8');
        fileOutputStream.write(0);
        fileOutputStream.write(1);


        //alt right + alt left// hot key

        Address address = new Address();
        address.setCountry("Armenia");
        address.setNumber(12);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeInt(123456);
        objectOutputStream.writeDouble(123456.4);
        objectOutputStream.writeFloat(123456.3f);
        objectOutputStream.writeChar('\n');
        objectOutputStream.writeObject(address);
        objectOutputStream.close();
        fileOutputStream.close();
/*
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readDouble());
        System.out.println(objectInputStream.readFloat());
        System.out.println((Address) objectInputStream.readObject());
        objectInputStream.close();


 */
    }
}