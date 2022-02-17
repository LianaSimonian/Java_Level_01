package com.aca.classroom.weeek;

public class Main {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        Car car = new Car();
        car.setAudioPlayer(audioPlayer);
        car.openDoor();
        Market market = new Market();
        Car car1 = market.carOption1();
        Car car2 = market.carOption2();
        System.out.println(market.count);


    }

}
