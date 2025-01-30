package ru.kurbatov.oop.any.geometry.figures;

import ru.kurbatov.oop.any.geometry.points.CreatorPoint;
import ru.kurbatov.oop.any.geometry.points.Point2D;

public class Rectangle extends Figure implements PolylineCalculable {

    protected int firstSide;
    private int secondSide;

    public Rectangle(Point2D firstPoint, int firstSide, int secondSide){
        super(firstPoint);
        checkSideLength(firstSide);
        checkSideLength(secondSide);
        this.firstSide = firstSide;
        this.secondSide = secondSide;
    }

    protected void checkSideLength(int sideLength){
        if (sideLength <= 0) throw new IllegalArgumentException("Side length must be positive");
    }

    @Override
    public double getArea() {
        return firstSide*secondSide;
    }

    @Override
    public double getLength() {
        return firstSide*2 + secondSide*2;
    }

    @Override
    public Polyline getPolyline() {
        return new Polyline(
                firstPoint,
                CreatorPoint.of(firstPoint.getX() + firstSide, firstPoint.getY()),
                CreatorPoint.of(firstPoint.getX() + firstSide, firstPoint.getY() - secondSide),
                CreatorPoint.of(firstPoint.getX(), firstPoint.getY() + secondSide),
                firstPoint);
    }
}
