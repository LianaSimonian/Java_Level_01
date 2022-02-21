package com.aca.classroom.week7.anunimus;

public class Main {
    public static void main(String[] args) {
        User user = new UserImpl("Lian", 11);
        User user1 = User.of("Lian", 12);
        User user3 = new User() {
            //anonimus
            public String getName() {
                return null;
            }

            public int getAge() {
                return 0;
            }
        };
    }


}
