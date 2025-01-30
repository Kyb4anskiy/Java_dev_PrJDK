package ru.kurbatov.oop.any.creatures.animals.birds;

import java.util.Random;

public class Cuckoo extends Bird{

    @Override
    public void sing() {
        for(int i = 0; i < (new Random().nextInt(10) + 1); i++){
            System.out.println("ку-ку");
        }
    }
}
