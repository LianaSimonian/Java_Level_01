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
/*
Create a ProgrammerLevel enum class that has 3 constants: JUNIOR, MID, SENIOR. Implement the toString method to return
"Junior programmer", "Mid programmer" and "Senior programmer" for JUNIOR, MID, SENIOR constants respectively.
 */