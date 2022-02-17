package com.aca.classroom.week6.factory;

public class MyBoolean {
    private static MyBoolean trueMyBoolean = null;
    private boolean value;

    public MyBoolean(boolean value) {
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    public static MyBoolean create(boolean value) {
        if (value == true) {
            if (trueMyBoolean == null) {
                trueMyBoolean = new MyBoolean(true);
            }
            return trueMyBoolean;
        }
        return new MyBoolean(value);
    }

    public static void main(String[] args) {
        MyBoolean myBoolean = new MyBoolean(true);
        MyBoolean myBoolean1 = MyBoolean.create(true);

    }
}
