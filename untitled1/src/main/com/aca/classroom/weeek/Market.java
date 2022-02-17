package com.aca.classroom.weeek;

public class Market {
     int count ;
     String name;
     public  Car carOption1(){
         count++;
         Car car = new Car();
         car.setAudioPlayer(new AudioPlayer());
         return car;
     }
     public  Car carOption2(){
         count++;
         return new Car();
     }
}
