package ru.kurbatov.oop.any.weapons;


public abstract class Weapon {

    protected int currentAmmo;


    public Weapon(int ammo){
        if (ammo < 0) throw new RuntimeException();
        this.currentAmmo = ammo;
    }

    public abstract void shoot();

    public int ammo(){ return currentAmmo;}

    public boolean isCharged(){
        return currentAmmo > 0;
    }

    public boolean getAmmo(){
        if(currentAmmo == 0) return false;
        currentAmmo--;
        return true;
    }

    public int load(int ammo){
        if(ammo < 0) throw  new RuntimeException();
        int tmp = ammo;
        this.currentAmmo = ammo;
        return tmp;
    }

    public int discharge(){
        int tmp = currentAmmo;
        currentAmmo = 0;
        return tmp;
    }
}
