package com.aca.homework.week10.concrate.map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class MapTest {
    private Map testMap;

    @BeforeEach
    public void setUp() {
        testMap = new Map();
    }

    @Test
    public void testPutWhenKeyIsNull() {
        NullPointerException nullPointerException = Assertions.assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testMap.put(null, "value1");
            }
        });
        Assertions.assertEquals("key is null", nullPointerException.getMessage());
    }

    @Test
    public void testPutWhenValueIsNull() {
        NullPointerException nullPointerException = Assertions.assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testMap.put("key1", null);
            }
        });
        Assertions.assertEquals("value is null", nullPointerException.getMessage());
    }

    @Test
    public void testGetValueWhenKeyIsNull() {
        NullPointerException nullPointerException = Assertions.assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testMap.getValue(null);
            }
        });
        Assertions.assertEquals("key is null", nullPointerException.getMessage());
    }

    @Test
    public void testGetValueWhenKeyIsNotFound() {
        testMap.put("key1", "value1");
        testMap.put("key2", "value2");
        testMap.put("key3", "value3");
        Assertions.assertNull(testMap.getValue("key4"));
    }

    @Test
    public void testGetValueWhenKeyIsFound() {
        testMap.put("key1", "value1");
        testMap.put("key2", "value2");
        testMap.put("key3", "value3");
        Assertions.assertEquals("value2", testMap.getValue("key2"));
    }

    @Test
    public void testSizeWhenEmpty() {
        Assertions.assertEquals(0, testMap.size());
    }

    @Test
    public void testSizeWhen1PairIsAdded() {
        testMap.put("key1", "value1");
        Assertions.assertEquals(1, testMap.size());
    }
}