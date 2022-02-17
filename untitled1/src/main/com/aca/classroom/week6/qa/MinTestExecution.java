package com.aca.classroom.week6.qa;

public class MinTestExecution extends TestExecution{
    public MinTestExecution(){
        super("Min function test");
    }

    public Result execute(){
        int min = Math.min(9, 99);
        if (min == 9) {
            return Result.PASS;
        } else {
            return Result.FAIL;
        }
    }
}
