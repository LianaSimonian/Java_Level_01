package com.aca.classroom.week6.qa;

public class MaxTestExecution extends TestExecution {
    public MaxTestExecution() {
        super("Max function test");
    }

    @Override
    public Result execute() {
        int max = Math.max(9, 99);
        if (max == 99) {
            return Result.PASS;
        } else {
            return Result.FAIL;
        }
    }
}
