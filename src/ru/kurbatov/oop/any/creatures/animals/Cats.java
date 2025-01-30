package ru.kurbatov.oop.any.creatures.animals;

public abstract class Cats implements Meowable{

    String name;

    public Cats(String name) {
        this.name = name;
    }

    @Override
    public void meow() {
        System.out.println(name + "Мяу");
    }

}
