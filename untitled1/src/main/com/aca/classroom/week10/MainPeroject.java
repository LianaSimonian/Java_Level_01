package com.aca.classroom.week10;


import java.util.*;

public class MainPeroject {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();//ArrayList
        for (int i = 0; i < 100_000; i++)
            list.add(i);
        printAll(list);
        List<Integer> list3 = Collections.emptyList();
    }

    //shift//shift-enter
    public static void printAll(List<Integer> list) {
        long start = System.currentTimeMillis();
        // for( int i =0;i<list.size();i++)
        //    System.out.println(list.get(i));
        for (Integer integer : list)
            System.out.println(integer);
        System.out.println(System.currentTimeMillis() - start);
    }
}
