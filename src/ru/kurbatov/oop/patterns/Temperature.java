package ru.kurbatov.oop.patterns;

import java.util.ArrayList;
import java.util.List;

public class Temperature {

    private static List<Temperature> poolTemperatures = new ArrayList<>();


    private String name;
    private int value;

    private Temperature(String name, int value){
        this.name = name;
        this.value = value;
    }

    public static Temperature getTemperature(int temperature){
        if (temperature > 60 || temperature < -50) throw new IllegalArgumentException("Temperature not founded");
        Temperature tmpTemperature = poolTemperatures.stream()
                .filter(x -> x.getValue() == temperature).findFirst().orElse(null);
        if (tmpTemperature != null)
            return tmpTemperature;
        if (temperature <= 10) tmpTemperature = new Temperature("COLD", temperature);
        else if (temperature <= 25 ) tmpTemperature = new Temperature("NORMAL", temperature);
        else tmpTemperature = new Temperature("HOT", temperature);
        poolTemperatures.add(tmpTemperature);
        return tmpTemperature;
    }

    public int getValue(){
        return value;
    }

    @Override
    public String toString() {
        return name + " " + value;
    }
}
