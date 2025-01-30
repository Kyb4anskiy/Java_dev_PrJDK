package ru.kurbatov.oop.any.geometry.figures;

import ru.kurbatov.oop.any.geometry.points.Point2D;

public class Circle extends Figure{

    private int radius;

    public Circle(Point2D center, int radius){
        super(center);
        if (radius <= 0) throw new IllegalArgumentException("Radius must be positive");
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius *radius;
    }

    @Override
    public double getLength() {
        return 2 * Math.PI * radius;
    }
}
