package com.aca.classroom.week15.service;

import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        Optional<User> user = getUser();

        user.map(User::getFirstName);

        //user.map(User::getFirstName).ifPresent(System.out::println);

          /*
         final Optional<String> username = user.map(User::getFirstName);
         /*
         if(user.isPresent()){
             System.out.println(user.get().getFirstName());
         }


       // System.out.println(user.getFirstName());
        //ecvivalent above 3
        user.map(User::getFirstName);
       // user->user.getUsername();
        new Function<User,String>(){
            @Override
            public String apply(User user) {
                return user.getFirstName();
            }
        };
          user.map(User::getFirstName).isPresent(System.out::println);
           */
    }

    public static Optional<User> getUser() {
        return Optional.ofNullable(null);
        /*
         return Optional.empty();
        return Optional.of(new User("u","f","k"));
        ofnullable()
         */
    }
}
