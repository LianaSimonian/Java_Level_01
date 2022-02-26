package com.aca.homework.week7.list.empty;

public interface List {
    int size();

    void add(Object o);

    boolean isEmpty();

    Object get(int index);

    public static List ofEmpty() {
        return new List() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public void add(Object o) {

            }

            @Override
            public boolean isEmpty() {
                return true;
            }

            @Override
            public Object get(int index) {
                System.out.println("empty list!!");
                return null;
            }
        };
    }

    public static List ofFixedSize() {
        return new FixedSizeList();
    }
}

