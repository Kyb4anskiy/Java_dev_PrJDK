package ru.kurbatov.oop.any.weapons;

public class Gun extends Weapon{

    protected final int maxAmmo;

    public Gun(){
       this(5);
    }

    public Gun(int maxAmmo){
        super(0);
        if (maxAmmo < 0) throw new IllegalArgumentException("maxAmmo must be positive");
        this.maxAmmo = maxAmmo;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    public int reload(int ammo){
        if (ammo < 0) throw new IllegalArgumentException("Ammo must be positive");
        if (ammo + this.currentAmmo >= maxAmmo){
            int tmp = currentAmmo;
            load(maxAmmo);
            return ammo - maxAmmo + tmp;
        }
        load(ammo);
        return 0;
    }

    @Override
    public void shoot(){
        shot();
    }

    protected void shot(){
        if (getAmmo()) {
            System.out.println("Бах!");
        }
        else System.out.println("Клац!");
    }

}
