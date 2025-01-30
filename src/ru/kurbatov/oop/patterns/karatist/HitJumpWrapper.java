package ru.kurbatov.oop.patterns.karatist;

public class HitJumpWrapper implements Hittable {

    public Karatist karatist;

    public HitJumpWrapper(Karatist karatist) {
        this.karatist = karatist;
    }

    @Override
    public void hit() {
        karatist.hitJump();
    }
}
