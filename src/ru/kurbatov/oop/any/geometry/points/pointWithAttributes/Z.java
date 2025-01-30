package ru.kurbatov.oop.any.geometry.points.pointWithAttributes;

public class Z extends Attribute{

    public Z(Integer value) {
        super("Z", value);
    }

    @Override
    public Integer getValue() {
        return (Integer)super.getValue();
    }
}
