package ru.kurbatov.oop.any.creatures.animals;

public class Lion extends Cats{

    public Lion(String name) {
        super(name);
    }

    public void meow(){
        System.out.println(name + ": " + "раррр");
    }

}
