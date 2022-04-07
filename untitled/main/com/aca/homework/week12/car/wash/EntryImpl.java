package com.aca.homework.week12.car.wash;

import java.io.Serializable;

public class EntryImpl<K, V> implements Entry<K, V>, Serializable {

    private K key;
    private V value;

    public EntryImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}