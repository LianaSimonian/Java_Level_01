package com.aca.classroom.week8.exception;

public class Main {
    public static void main(String[] args) {
        // throw new RuntimeException();
        //  System.err.println("error");
        RuntimeException exception = new RuntimeException();
        // Exception exception1 = new Exception();
        //throw exception1;
        // throw exception;
        //Throwable extends objects
        createUser();
    }

    public static User createUser() {
        return new User(null, "first name");

    }
    //stacktraise "red part"
}
