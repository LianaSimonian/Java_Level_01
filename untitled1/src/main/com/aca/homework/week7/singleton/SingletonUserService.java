package com.aca.homework.week7.singleton;

public class SingletonUserService {
    private static SingletonUserService singletonObject = null;

    private SingletonUserService() {
    }

    public static SingletonUserService getInstance() {
        if (singletonObject == null) {
            singletonObject = new SingletonUserService();
        }
        return singletonObject;
    }

}

