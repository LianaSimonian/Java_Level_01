package com.aca.classroom.week7.concat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LongConcatenator {
    private LongConcatenator testSubject;
    @BeforeEach
    public void setUp(){
        testSubject = new LongConcatenator();
    }
    public String concat(long l1,long l2){

        return l1+""+l2;
    }

}
