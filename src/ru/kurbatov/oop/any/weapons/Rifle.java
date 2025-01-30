package ru.kurbatov.oop.any.weapons;

public class Rifle extends Gun{

    private int rateOfFire;

    public Rifle(){
        this(20,30);
    }

    public Rifle(int maxAmmo){
        this(maxAmmo, maxAmmo/2);
    }

    public Rifle(int maxAmmo, int rateOfFire){
        super(maxAmmo);
        setRateOfFire(rateOfFire);
    }

    private void setRateOfFire(int rateOfFire){
        if (rateOfFire <= 0) throw new IllegalArgumentException("RateOfFire must be positive");
        this.rateOfFire = rateOfFire;
    }

    @Override
    public void shoot(){
        for(int i = 0; i < rateOfFire; i++) super.shot();
    }

    public void shoot(int seconds){
        for(int i = 0; i < seconds; i++) shoot();
    }
}
