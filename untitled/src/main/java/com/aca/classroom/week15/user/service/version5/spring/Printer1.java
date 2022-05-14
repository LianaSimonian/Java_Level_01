package com.aca.classroom.week15.user.service.version5.spring;

import org.springframework.stereotype.Component;

@Component(value = "defaultPrinter")
public class Printer1 implements Printer {
    @Override
    public void print() {
        System.out.println("printer1");
    }
}