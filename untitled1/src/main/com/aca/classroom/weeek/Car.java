package com.aca.classroom.weeek;

public class Car {

    private AudioPlayer audioPlayer;
    public Car(){

    }
    public Car(AudioPlayer audioPlayer){
        this.audioPlayer=audioPlayer;
    }
    public void setAudioPlayer(AudioPlayer audioplayer) {
        this.audioPlayer = audioplayer;

    }


    public void openDoor() {
        if (audioPlayer != null) {
            audioPlayer.play();
            long start = System.currentTimeMillis();
            wait3Seconds(start);
            audioPlayer.stop();
        } else {
            System.out.println("does not have audioPlayer");
        }


    }

    public static void wait3Seconds(long start) {
        while (System.currentTimeMillis() - start < 3000) {

        }
    }
}
