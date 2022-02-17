package com.aca.homework.week5.programmer.level;

public enum ProgrammerLevel {
    JUNIOR,
    MID,
    SENIOR;

    public String toString() {
        switch (this) {
            case JUNIOR:
                return "Junior programmer";
            case MID:
                return "Mid programmer";
            case SENIOR:
                return "Senior programmer";
        }
        throw new RuntimeException();
    }
}