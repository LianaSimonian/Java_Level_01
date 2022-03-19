package com.aca.classroom.week10.runnable;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Runnable mulRunnable = new MulRunnable(1, 9);
        Runnable subRunnable = new SubtractionRunnable(1, 9);
        Runnable sumRunnable = new AddRunnable(1, 2);
        //will be good  access with interface ,it helps to do changes only one space
        //we will write real name only if we must call function that have not
        // in interface and specific only that class
        List<Runnable> list = new LinkedList<>();//ArrayList
        list.add(mulRunnable);
        list.add(subRunnable);
        list.add(sumRunnable);
        mutate(list);
        runRunnable(list);
    }

    public static void runRunnable(List<Runnable> runnableList) {
        for (Runnable runnable : runnableList)//for(int i =0;i<runnuble.size();i++)
            runnable.run();
    }

    public static void mutate(List<Runnable> runnableList) {
        runnableList.remove(0);
        runnableList = null;
    }
    //see image of stackFrame
}
