package com.aca.classroom.week6.set;

public class ArraySet extends AbstractSet implements Set {
    private User[] array = new User[10];
    private int pointer;

    @Override
    public void add(User user) {
        if (contains(user)) {
            System.out.println("The user:" + user.toString() + "already exists");
            return;
        }

        array[pointer] = user;
        pointer++;

    }

    @Override
    public boolean contains(User user) {
        for (int i = 0; i < pointer; i++) {
            if (user.equals(array[i]))
                return true;
        }
        return false;
    }

    @Override
    public int size() {
        return pointer;
    }
}
