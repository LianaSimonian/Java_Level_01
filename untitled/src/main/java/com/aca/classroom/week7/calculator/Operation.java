package com.aca.classroom.week7.calculator;

public enum Operation {
    ADDITION {
        @Override
        public double calculate(double number1, double number2) {
            return number1 + number2;
        }
    },
    SUBTRACTION {
        @Override
        public double calculate(double number1, double number2) {
            return number1 - number2;
        }
    },
    MULTIPLICATION {
        @Override
        public double calculate(double number1, double number2) {
            return number1 * number2;
        }
    },
    DIVISION {
        @Override
        public double calculate(double number1, double number2) {
            return number1 / number2;
        }
    };

    public abstract double calculate(double number1, double number2);
}

/*
public enum Operation {
    ADDITION,
    SUBTRACTION,
    DIVISION,
    MULTIPLICATION;

    public double calculate(double n1, double n2) {
        if (this == ADDITION) {
            return n1 + n2;
        } else if (this == MULTIPLICATION) {
            return n1 * n2;
        }
        return 0;
    }
}
*/