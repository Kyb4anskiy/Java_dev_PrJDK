package ru.kurbatov.oop.any.creatures.animals;

public class DogCat implements Meowable, Barkable{

    private String name;

    public DogCat(String name) {
        this.name = name;
    }

    @Override
    public void bark() {
        System.out.println(name + ": ГААВ");
    }

    @Override
    public void meow() {
        System.out.println(name + ": МЯУ");
    }
}
