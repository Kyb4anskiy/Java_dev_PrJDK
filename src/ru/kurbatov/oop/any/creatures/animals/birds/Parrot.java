package ru.kurbatov.oop.any.creatures.animals.birds;

import java.util.Random;

public class Parrot extends Bird{

    private String song;

    public Parrot(String song){
        this.song = song;
    }

    @Override
    public void sing() {
        System.out.println(song.substring(0, new Random().nextInt(song.length()) + 1));
    }
}
