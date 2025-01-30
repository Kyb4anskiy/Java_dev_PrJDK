package ru.kurbatov.oop.patterns.karatist;

public class HitLegWrapper implements Hittable {

    public Karatist karatist;

    public HitLegWrapper(Karatist karatist) {
        this.karatist = karatist;
    }

    @Override
    public void hit() {
        karatist.hitLeg();
    }
}
