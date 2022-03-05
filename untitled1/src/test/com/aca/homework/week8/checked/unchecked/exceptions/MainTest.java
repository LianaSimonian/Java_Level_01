package com.aca.homework.week8.checked.unchecked.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.opentest4j.AssertionFailedError;

class MainTest {
    @Test
    public void testForMethod5() {
        Exception exception = Assertions.assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Main.method5();
            }
        });
        Assertions.assertEquals("unhandled exception in method5" , exception.getMessage());
    }

    @Test
    public void testForMethod4() {
        Exception exception = Assertions.assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Main.method4();
            }
        });
        Assertions.assertEquals("unhandled exception in method5" , exception.getMessage());
    }

    @Test
    public void testForMethod3() {
        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Main.method3();
            }
        });
        Assertions.assertEquals("unhandled RuntimeException in method3" , runtimeException.getMessage());
    }

    @Test
    public void testForMethod2() {
        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Main.method2();
            }
        });
        Assertions.assertEquals("unhandled RuntimeException in method3" , runtimeException.getMessage());
    }

    @Test
    public void testForMethod1() {
        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Main.method1();
            }
        });
        Assertions.assertEquals("unhandled RuntimeException in method3" , runtimeException.getMessage());
    }

    public static void main(String[] args) {
        try {
            Main.method1();
        } catch (RuntimeException e) {
            System.err.println("catch");
        }
        System.err.println("finished");
    }
}