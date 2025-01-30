package ru.kurbatov.oop.any.creatures.animals;

public class MeowableCounter implements Meowable{

    private Meowable meowableObj;
    private int countMeowable;

    public MeowableCounter(Meowable meowableObj) {
        this.meowableObj = meowableObj;
    }

    @Override
    public void meow() {
        meowableObj.meow();
        countMeowable++;
    }

    public int getCountMeowable(){
        return countMeowable;
    }
}
