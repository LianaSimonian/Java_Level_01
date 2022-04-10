package com.aca.classroom.week13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListMain {

    public static void main(String[] args) {

        List<String> list = List.of("a", "b");
        System.out.println(list.add("dgdfopgid"));
        List<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
    }
}
