package com.aca.classroom.week7.annotations;
public class StringMakerResult {

    private long duration;
    private String text;

    public StringMakerResult( long duration,String text) {
        this.text = text;
        this.duration = duration;
    }

    public String getText() {
        return text;
    }

    public long getDuration() {
        return duration;
    }
}

/*
public class Result {
    private String text;
   private long time;

    public Result(String string, long time) {
       // this.string = string;
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public String getString() {
      //  return string;
        return " ";
    }
}

 */
