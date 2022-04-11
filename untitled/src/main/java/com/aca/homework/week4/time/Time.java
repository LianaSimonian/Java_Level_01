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
        System.out.println(patternHours(getHours()) + ":" + patternMinutes(getMinutes()) + ":" + patternSeconds(getSeconds()));
    }

    public static String patternSeconds(long seconds) {
        return seconds <= 9 && seconds >= 0 ? "0" + seconds : Long.toString(seconds);
    }

    public static String patternMinutes(long minutes) {
        return minutes <= 9 && minutes >= 0 ? "0" + minutes : Long.toString(minutes);
    }

    public static String patternHours(long hours) {
        return hours <= 9 && hours >= 0 ? "0" + hours : Long.toString(hours);
    }

}
