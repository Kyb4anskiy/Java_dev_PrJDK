package ru.kurbatov.oop.any.creatures.animals;

public class Dog implements Barkable{

    String name;

    public Dog(String name){
        this.name = name;
    }

    @Override
    public void bark() {
        System.out.println(name + ": гав!");
    }

    @Override
    public String toString() {
        return "Собака: " + name;
    }
}
