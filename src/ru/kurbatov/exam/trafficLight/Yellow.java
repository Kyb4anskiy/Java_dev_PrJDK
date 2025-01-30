package ru.kurbatov.exam.trafficLight;

public class Yellow implements Lightable{
    @Override
    public Lightable changeColor() {
        return new Red();
    }

    @Override
    public String getColor() {
        return "Желтый";
    }
}
