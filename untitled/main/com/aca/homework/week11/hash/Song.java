package com.aca.homework.week11.hash;

public class Song {
    private  Singer singer;
    private final String name;
    private final long duration;
    private float rating;

    public Song(Singer singer, String name, long duration, float rating) {
        this.singer = singer;
        this.name = name;
        this.duration = duration;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;
        return singer.equals(((Song) o).singer) && name.equals(((Song) o).name) && duration == ((Song) o).duration && rating == ((Song) o).rating;
    }

    @Override
    public int hashCode() {
        int result = singer != null ? singer.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}