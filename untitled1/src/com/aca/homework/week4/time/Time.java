package com.aca.homework.week4.time;
/*Create a Time method that takes seconds of a day in a constructor (starting from 00:00:00) and provides 3 method
 to get hours, minutes and seconds of the time.
        Time time = new Time(0)
        time.getSeconds() -> should return 0
        time.getMinutes() -> should return 0
        time.getHours() -> should return 0


        Time time = new Time(3600+5*60+6)
        time.getSeconds() -> should return 6
        time.getMinutes() -> should return 5
        time.getHours() -> should return 1

        print the result of each method invocation
*/
public class Time {
    private long seconds;

    public Time() {
        seconds = 0;
    }

    public Time(long seconds) {
        this.seconds = seconds - (seconds / (24 * 60 * 60)) * (24 * 60 * 60);
    }

    public long getSeconds() {
        return seconds - getHours() * 3600 - getMinutes() * 60;
    }

    public long getMinutes() {
        return (seconds - getHours() * 3600) / 60;
    }

    public long getHours() {
        return seconds / 3600;
    }

    public void print() {
        long hours = getHours();
        long minutes = getMinutes();
        long seconds = getSeconds();
        if (hours >= 0 && hours <= 9) {
            if (minutes >= 0 && minutes <= 9) {
                if (seconds >= 0 && seconds <= 9) {
                    System.out.println("0" + hours + ":0" + minutes + ":0" + seconds);
                } else {
                    System.out.println("0" + hours + ":0" + minutes + ":" + seconds);
                }
            } else {
                if (seconds >= 0 && seconds <= 9) {
                    System.out.println("0" + hours + ":" + minutes + ":0" + seconds);
                } else {
                    System.out.println("0" + hours + ":" + minutes + ":" + seconds);
                }

            }
        } else {
            if (minutes >= 0 && minutes <= 9) {
                if (seconds >= 0 && seconds <= 9) {
                    System.out.println(hours + ":0" + minutes + ":0" + seconds);
                } else {
                    System.out.println(hours + ":0" + minutes + ":" + seconds);
                }
            } else {
                if (seconds >= 0 && seconds <= 9) {
                    System.out.println(hours + ":" + minutes + ":0" + seconds);
                } else {
                    System.out.println(hours + ":" + minutes + ":" + seconds);
                }
            }
        }
    }
}
