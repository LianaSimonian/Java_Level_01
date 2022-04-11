package com.aca.classroom.week10.week10;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MainProject {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();//ArrayList
        for (int i = 0; i < 100_000; i++)
            list.add(i);
        printAll(list);
        List<Integer> list3 = Collections.emptyList();
        List<Integer> list4 = Collections.singletonList(12);
        List<Integer> list5 = List.of();
    }

    //shift//shift-enter
    public static void printAll(List<Integer> list) {
        long start = System.currentTimeMillis();
        /*
         for( int i =0;i<list.size();i++)
            System.out.println(list.get(i));

         */
        for (Integer integer : list)
            System.out.println(integer);
        System.out.println(System.currentTimeMillis() - start);
    }
}
