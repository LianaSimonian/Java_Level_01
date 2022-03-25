package com.aca.homework.week9.expressioncalculator;

public enum Operation {
    ADDITION('+') {
        @Override
        public double calculate(int number1, int number2) {
            return number1 + number2;
        }
    },
    SUBTRACTION('-') {
        @Override
        public double calculate(int number1, int number2) {
            return number1 - number2;
        }
    },
    DIVISION('/') {
        @Override
        public double calculate(int number1, int number2) {
            return (double) number1 / number2;
        }
    },
    MULTIPLICATION('*') {
        @Override
        public double calculate(int number1, int number2) {
            return number1 * number2;
        }
    };

    private char operationSymbol;

    Operation(char operationSymbol) {
        this.operationSymbol = operationSymbol;
    }

    public char getOperationSymbol() {
        return operationSymbol;
    }

    public abstract double calculate(int number1, int number2);

    public static Operation operationOf(char symbol) {
        for (Operation operation : Operation.values())
            if (operation.operationSymbol == symbol)
                return operation;

        throw new IllegalArgumentException("can not convert to char");
    }

    public static boolean isOperation(char symbol) {
        for (Operation operation : Operation.values())
            if (operation.operationSymbol == symbol)
                return true;
        return false;
    }
}

