package com.aca.classroom.week10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(1000);
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);
        Iterator<Integer> iterator = list.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for (Integer integer : list) {
            System.out.println(iterator.next());
        }
        Iterator<Integer> iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next() == 4) iterator1.remove();
        }
        for( int i =0;i<list.size();i++)
            System.out.println(list.get(i));

       // Iterator<Integer> iterator2 = list.iterator();
        //System.out.println(list);

    }
}
//skeletal implementation

