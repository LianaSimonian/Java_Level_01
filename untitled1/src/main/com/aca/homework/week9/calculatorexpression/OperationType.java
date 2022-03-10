package com.aca.homework.week9.calculatorexpression;

public enum OperationType {
    ADDITION {
        @Override
        public double calculate(int number1, int number2) {
            return number1 + number2;
        }
    },
    SUBTRACTION {
        @Override
        public double calculate(int number1, int number2) {
            return number1 - number2;
        }
    },
    DIVISION {
        @Override
        public double calculate(int number1, int number2) {
            return (double) number1 / number2;
        }
    },
    MULTIPLICATION {
        @Override
        public double calculate(int number1, int number2) {
            return number1 * number2;
        }
    };

    public abstract double calculate(int number1, int number2);

    public static OperationType charConvertToOperationType(char type) {
        switch (type) {
            case '+':
                return ADDITION;
            case '-':
                return SUBTRACTION;
            case '/':
                return DIVISION;
            case '*':
                return MULTIPLICATION;
        }
        throw new IllegalArgumentException("can not convert to char");
    }
}