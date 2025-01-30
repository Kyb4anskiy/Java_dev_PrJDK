package ru.kurbatov.exam.trafficLight;

public class Red implements Lightable{
    @Override
    public Lightable changeColor() {
        return new Green();
    }

    @Override
    public String getColor() {
        return "Красный";
    }
}
