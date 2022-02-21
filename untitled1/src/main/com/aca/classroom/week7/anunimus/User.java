package com.aca.classroom.week7.anunimus;

public interface User {
    String getName();

    int getAge();

    static User ofImpl(String name, int age) {
        return new UserImpl(name, age);
    }


    static User of(String name, int age) {
        // return new UserImpl(name,age) ;
        return new User() {
            //anonimus
            public String getName() {
                return null;
            }

            public int getAge() {
                return 0;
            }

        };
    }
}//anonimus implementation
