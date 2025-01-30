package ru.kurbatov.oop.any.creatures.animals;

public class MeowableWarning implements Meowable{

    private Meowable meowableObj;

    public MeowableWarning(Meowable meowableObj) {
        this.meowableObj = meowableObj;
    }

    @Override
    public void meow() {
        System.out.println("Внимание");
        meowableObj.meow();
    }

}
