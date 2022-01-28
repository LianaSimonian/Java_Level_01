package com.aca.homework.week2.user.creation;

public class UserCreation {
    public static void printUser(User user) {

        System.out.println("The name is:" + user.name + ", Marry's height is:" + user.height);
    }

    public static void main(String[] args) {

        User[] users = new User[3];

        users[0] = new User("Marry", 170);
        users[1] = new User("Grace", 169);
        users[2] = new User("Nicolas", 175);

        for (int i = 0; i < users.length; i++) {
            printUser(users[i]);
        }
    }
}