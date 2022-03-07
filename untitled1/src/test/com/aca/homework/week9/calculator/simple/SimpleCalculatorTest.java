package com.aca.homework.week9.calculator.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class SimpleCalculatorTest {

    @Test
    public void testWhenInputStringLengthIs1() {
        SimpleCalculator testSubject = new SimpleCalculator(new StringSupplier() {
            @Override
            public String get() {
                return "l";
            }
        });
        Assertions.assertEquals("error", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenInputStringLengthIs2() {
        SimpleCalculator testSubject = new SimpleCalculator(new StringSupplier() {
            @Override
            public String get() {
                return "12";
            }
        });
        Assertions.assertEquals("error", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenInputStringLengthIs4() {
        SimpleCalculator testSubject = new SimpleCalculator(new StringSupplier() {
            @Override
            public String get() {
                return "1224";
            }
        });
        Assertions.assertEquals("error", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenInputStringLengthIs3ButFirstSymbolIsNotDigit() {
        SimpleCalculator testSubject = new SimpleCalculator(new StringSupplier() {
            @Override
            public String get() {
                return "h+9";
            }
        });
        Assertions.assertEquals("error", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenInputStringLengthIs3ButSecondSymbolIsNotOperation() {
        SimpleCalculator testSubject = new SimpleCalculator(new StringSupplier() {
            @Override
            public String get() {
                return "1e9";
            }
        });
        Assertions.assertEquals("error", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenInputStringLengthIs3ButThirdSymbolIsNotDigit() {
        SimpleCalculator testSubject = new SimpleCalculator(new StringSupplier() {
            @Override
            public String get() {
                return "1+e";
            }
        });
        Assertions.assertEquals("error", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenOperationIsSum() {
        SimpleCalculator testSubject = new SimpleCalculator(new StringSupplier() {
            @Override
            public String get() {
                return "1+5";
            }
        });
        Assertions.assertEquals("6", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenOperationIsDivision() {
        SimpleCalculator testSubject = new SimpleCalculator(new StringSupplier() {
            @Override
            public String get() {
                return "6/2";
            }
        });
        Assertions.assertEquals("3.0", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenOperationIsSubtraction() {
        SimpleCalculator testSubject = new SimpleCalculator(new StringSupplier() {
            @Override
            public String get() {
                return "6-2";
            }
        });
        Assertions.assertEquals("4", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenOperationIsMultiplication() {
        SimpleCalculator testSubject = new SimpleCalculator(new StringSupplier() {
            @Override
            public String get() {
                return "6*2";
            }
        });
        Assertions.assertEquals("12", testSubject.askAndCalculate());
    }
}