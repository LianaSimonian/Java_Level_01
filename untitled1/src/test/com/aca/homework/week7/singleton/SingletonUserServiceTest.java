package com.aca.homework.week7.singleton;

class
SingletonUserServiceTest {
    public static void main(String[] args) {
        SingletonUserService instance1 = SingletonUserService.getInstance();
        SingletonUserService instance2 = SingletonUserService.getInstance();
        SingletonUserService instance3 = SingletonUserService.getInstance();
        SingletonUserService instance4 = SingletonUserService.getInstance();
        System.out.println(instance1 == instance2 && instance2 == instance3 && instance3 == instance4);

    }
}