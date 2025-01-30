package ru.kurbatov.oop.any.creatures.animals;

public class Cat extends Cats{

    public Cat(String name){
        super(name);
    }

    public void meow(){
        System.out.println(name + ": " + "мяу");
    }

    public void meow(int countMew){
        if (countMew <= 0) return;
        String res = name + ": ";
        for (int i = 0; i < countMew; i++){
            res += "мяу";
            if (i == countMew - 1)
                res += "!";
            else
                res += "-";
        }
        System.out.println(res);

    }

    public String toString(){
        return "кот: " + name;
    }
}
