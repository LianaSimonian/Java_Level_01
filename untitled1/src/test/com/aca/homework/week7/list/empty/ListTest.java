package com.aca.homework.week7.list.empty;

class ListTest {
    public static void main(String[] args) {
        List list1 = List.ofEmpty();
        System.out.println(list1.isEmpty());

        List list2 = List.ofFixedSize();
        for (int i = 0; i < 10; i++)
            list2.add(i + "");

        list2.add("fool");
        System.out.println("size= " + list2.size());
        System.out.println(list2.get(3));

    }

}