package com.aca.classroom.week10.map;

public class Main {
    public static void main(String[] args) {
        User user = new User("name1", 15);
        System.out.println(user.hashCode());
        User user2 = new User("name2", 15);
        System.out.println(user2.hashCode());
        User user3 = new User("name2", 15);
        System.out.println(user3.hashCode());
        //if 2 objects are equal they hashcode will be same
    }
}
