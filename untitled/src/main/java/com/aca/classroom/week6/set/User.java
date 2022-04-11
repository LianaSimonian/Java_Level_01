package com.aca.classroom.week6.set;

public class User {
    private String firstname;
    private String lastname;

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this == null) return false;
        if (o == null || o.getClass() != User.class) {
            return false;
        }
        User user = (User) o;
        return user.firstname.equals(firstname) && user.lastname.equals(lastname);
    }

    public static void main(String[] args) {
        User user = new User("F", "L");
        User childuser = new User("F", "L");
        System.out.println(user instanceof User);//dir
        System.out.println(childuser instanceof User);
    }
}