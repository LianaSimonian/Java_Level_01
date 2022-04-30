package com.aca.classroom.week15.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerMain.class);

    public static void main(String[] args) {
        max(5, 10);
    }

    public static int max(int a, int b) {
        LOGGER.debug("Calculating maximum between numbers a {} and b {}", a, b);
        return a > b ? a : b;
    }
}