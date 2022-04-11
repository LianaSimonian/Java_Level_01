package com.aca.classroom.week10.map;

import java.util.Objects;

public class HashTest {
    private int a;
    //  private int b;
    // private int c;

    public HashTest(int a, int b, int c) {
        this.a = a;
        // this.b = b;
        // this.c = c;
    }

    @Override
    public int hashCode() {
        Integer.hashCode(a);
        return a;
    }

    public static void main(String[] args) {
        Objects.hash();
    }
}
