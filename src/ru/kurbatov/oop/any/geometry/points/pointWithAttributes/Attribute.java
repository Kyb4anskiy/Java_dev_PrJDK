package ru.kurbatov.oop.any.geometry.points.pointWithAttributes;

public abstract class Attribute {

    private final String name;
    private Object value;

    public Attribute(String name, Object value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name + " " + value.toString();
    }
}
