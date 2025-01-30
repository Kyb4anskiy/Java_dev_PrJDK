package ru.kurbatov.oop.any.geometry.points.pointWithAttributes;

public class TimeSpawn extends Attribute{

    public TimeSpawn(String value) {
        super("TimeSpawn", value);
    }

    @Override
    public String getValue() {
        return (String) super.getValue();
    }
}
