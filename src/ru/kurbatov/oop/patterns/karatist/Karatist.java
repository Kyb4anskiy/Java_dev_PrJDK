package ru.kurbatov.oop.patterns.karatist;

public class Karatist {

    private final String name;

    public Karatist(String name) {
        this.name = name;
    }

    public void hitHand(){
        System.out.println(name + " Kiya");
    }

    public void hitLeg(){
        System.out.println(name + " Batch");
    }

    public void hitJump(){
        System.out.println(name + " Vjuh");
    }




}
