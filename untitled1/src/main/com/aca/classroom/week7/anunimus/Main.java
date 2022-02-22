package com.aca.classroom.week7.anunimus;

public class Main {
    public static void main(String[] args) {
        User user = new UserImpl("name", 11);
        User user1 = User.of("name", 12);

        //anonymous class ,implementation
        User user3 = new User() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public int getAge() {
                return 0;
            }
        };
    }

}
