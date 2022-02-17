package com.aca.classroom.week6.qa;

public class AbsTestExecution extends TestExecution {
    public AbsTestExecution() {
        super("Abs function test");
    }

    public Result execute() {
        int abs = Math.abs(-8);

        if (Math.abs(-8) != 8) {
            return Result.PASS;
        } else {
            return Result.FAIL;
        }
    }
}
