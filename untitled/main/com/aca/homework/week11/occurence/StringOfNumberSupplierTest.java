package com.aca.homework.week11.occurence;

public class StringOfNumberSupplierTest implements Supplier<String> {
    private int numberOfCallGetFunction;

    @Override
    public String get() {
        numberOfCallGetFunction++;
        if (numberOfCallGetFunction == 1)
            return "1";
        if (numberOfCallGetFunction == 2)
            return "1";
        if (numberOfCallGetFunction == 3)
            return "5";
        if (numberOfCallGetFunction == 4)
            return "5";
        if (numberOfCallGetFunction == 5)
            return "49";
        if (numberOfCallGetFunction == 6)
            return "1";
        if (numberOfCallGetFunction == 7)
            return "end";
        return null;
    }
}
