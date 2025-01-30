package ru.kurbatov.oop.any.geometry.points.pointWithAttributes;

public class Y extends Attribute{

    public Y(Integer value) {
        super("Y", value);
    }

    @Override
    public Integer getValue() {
        return (Integer)super.getValue();
    }
}
