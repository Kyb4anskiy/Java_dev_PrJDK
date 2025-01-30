package ru.kurbatov.oop.patterns.karatist;

import java.util.List;

public class Combo {

    private List<Hittable> combo;

    public Combo(List<Hittable> combo) {
        this.combo = combo;
    }

    public void hitCombo(){
        combo.forEach(Hittable::hit);
    }
}
