package ru.kurbatov.oop.any.geometry.figures;

import ru.kurbatov.oop.any.geometry.Coordinate;
import ru.kurbatov.oop.any.geometry.Shiftable;
import ru.kurbatov.oop.any.geometry.points.Point2D;

public abstract class Figure implements LengthCalculable, Shiftable {

    protected Point2D firstPoint;

    public Figure(Point2D firstPoint){
        this.firstPoint = firstPoint;
    }

    public abstract double getArea();

    @Override
    public void shift(Coordinate coord, int shift) {
        firstPoint.shift(coord,shift);
    }
}
