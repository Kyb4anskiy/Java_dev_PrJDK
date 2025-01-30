package ru.kurbatov.oop.any.creatures.humans;

import ru.kurbatov.oop.any.weapons.Weapon;

public class BestShooter {

    String name;
    Weapon weapon;

    public BestShooter(String name){
        this(name, null);
    }

    public BestShooter(String name, Weapon weapon){
        this.name = name;
        this.weapon = weapon;
    }

    public void shoot(){
        if (weapon == null)
            System.out.println("Не могу участвовать в перестрелке");
        else weapon.shoot();
    }

    @Override
    public String toString() {
        return name + " " + weapon;
    }
}
