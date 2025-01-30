package ru.kurbatov.exam.trafficLight;

import java.util.List;

public class Green implements Lightable{
    @Override
    public Lightable changeColor() {
        return new Yellow();
    }

    @Override
    public String getColor() {
        return "Зеленый";
    }
}
