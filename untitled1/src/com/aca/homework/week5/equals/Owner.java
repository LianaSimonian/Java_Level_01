package com.aca.homework.week5.equals;

import java.util.Objects;

public class Owner {
    private String firstName;
    private String lastName;

    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        if (isOfTypeOwner(o)) {
            Owner owner = (Owner) o;
            return firstName.equals(owner.firstName) && lastName.equals(owner.lastName);
        }
        return false;
    }

    public void print() {
        System.out.println(toString());
    }

    public static boolean isOfTypeOwner(Object o) {
        return o.getClass() == Owner.class;
    }
}
/*
Create an Owner class that has firstName and lastName. Implement toString and equals method.

Create a Motorcycle class that has a brand (SUZUKI, YAMAHA is allowed only) and an owner. Implement toString and equals methods of Motorcycle class.

Create a Motorcycle of YAMAHA type owner of which is 'Yorgantz' 'Mark.
Create a Motorcycle of YAMAHA type owner of which is 'Tavares 'Mark.

print the above objects, compare them and print the result.
 */