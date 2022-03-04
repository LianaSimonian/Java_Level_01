package com.aca.classroom.week8.buffer.generic;

public interface Buffer<T> {
    void put(T o);

    T get();

    public static void main(String[] args) {
        Buffer<Integer> integerBuffer = null;
        integerBuffer.put(4545);
        Integer integer = integerBuffer.get();
        Buffer<String> stringBuffer = null;
        stringBuffer.put("4545");
        Integer string = integerBuffer.get();
        Buffer<Integer> integerBufferanonimus = new Buffer<Integer>() {
            @Override
            public void put(Integer o) {

            }

            @Override
            public Integer get() {
                return null;
            }
        };
    }
}
