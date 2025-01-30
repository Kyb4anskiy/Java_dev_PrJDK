package ru.kurbatov.oop.other;

import ru.kurbatov.oop.any.geometry.points.Point2D;

public class Car {

    String model;
    String vin;
    double fuel, wasteOfFuel;

    public Point2D currentPoint;

    static final double LITERS_IN_GALLONS = 4.54;

    public Car(String model, String vin, Point2D currentPoint, double fuel, double wasteOfFuel){
        this.model = model;
        this.vin = vin;
        this.currentPoint = currentPoint;
        this.fuel = fuel;
        this.wasteOfFuel = wasteOfFuel;
    }

    public void ride(){
        double dis = 0;
        while (fuel >= wasteOfFuel){
            dis++;
            fuel -= wasteOfFuel;
        }
        if (wasteOfFuel != 0) dis += fuel/wasteOfFuel;

        System.out.println(model + " " + vin +
                " проехал " + dis);
    }
    public void refuel(double newFuel){
        fuel = newFuel;
        System.out.println(model + " " + vin +
                " заправился на " + newFuel);
    }

    public String toString(){
        return "Модель " + model +
                " Номер " + vin +
                " Координаты " + currentPoint.toString();
    }

    double getFuelToLiters(){
        return fuel;
    }
    double getFuelToGallons(){
        return fuel / LITERS_IN_GALLONS;
    }

}
