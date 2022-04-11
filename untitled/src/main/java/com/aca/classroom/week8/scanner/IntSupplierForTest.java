package com.aca.classroom.week8.scanner;

import java.util.InputMismatchException;

public class IntSupplierForTest extends IntSupplier {
    private int counter;

    @Override
    public int get() {
        counter++;
        if (counter == 1) {
            return 9;
        }
        if (counter == 2) {
            throw new InputMismatchException();
        }
        if (counter == 3) {
            return 10;
        }
        if (counter == 4) {
            throw new InputMismatchException();
        }
        if (counter == 5) {
            return 4;
        }
        if (counter == 6) {
            return 5;
        }
        if (counter == 7) {
            return 6;
        }
        return 0;
    }
}