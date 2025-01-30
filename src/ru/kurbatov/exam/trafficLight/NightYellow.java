package ru.kurbatov.exam.trafficLight;

public class NightYellow implements Lightable{
    @Override
    public Lightable changeColor() {
        return this;
    }

    @Override
    public String getColor() {
        return "Желтый";
    }
}
