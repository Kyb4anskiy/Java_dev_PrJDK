package ru.kurbatov.oop.patterns.karatist;

public class HitHandWrapper implements Hittable{

    public Karatist karatist;

    public HitHandWrapper(Karatist karatist) {
        this.karatist = karatist;
    }

    @Override
    public void hit() {
        karatist.hitHand();
    }
}
