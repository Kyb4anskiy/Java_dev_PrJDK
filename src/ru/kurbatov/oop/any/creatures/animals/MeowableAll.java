package ru.kurbatov.oop.any.creatures.animals;

public class MeowableAll implements Meowable{
    public Meowable cat;
    public MeowableCounter meowableCounter;
    public MeowableWarning meowableWarning;

    public MeowableAll(Meowable cat) {
        this.cat = cat;
    }


    @Override
    public void meow() {
        meowableWarning.meow();
        meowableCounter.meow();
    }
}
