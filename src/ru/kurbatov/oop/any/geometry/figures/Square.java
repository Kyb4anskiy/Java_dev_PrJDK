package ru.kurbatov.oop.any.geometry.figures;

import ru.kurbatov.oop.any.geometry.points.CreatorPoint;
import ru.kurbatov.oop.any.geometry.points.Point2D;

public class Square extends Rectangle{

    public Square(Point2D firstPoint, int sideLength){
        super(firstPoint, sideLength, sideLength);
    }

    public Square(int x, int y, int sideLength){
        this(CreatorPoint.of(x, y), sideLength);
    }

    public void setSideLength(int sideLength) {
        checkSideLength(sideLength);
        firstSide = sideLength;
    }

    public int getSideLength() {
        return firstSide;
    }

    public Polyline getPolyline(){
        return new ClosePolyline(
                firstPoint,
                CreatorPoint.of(firstPoint.getX() + firstSide, firstPoint.getY()),
                CreatorPoint.of(firstPoint.getX() + firstSide, firstPoint.getY() - firstSide),
                CreatorPoint.of(firstPoint.getX(), firstPoint.getY() + firstSide),
                firstPoint);
    }

    @Override
    public double getArea() {
        return firstSide*firstSide;
    }

    @Override
    public String toString(){
        return String.format("Квадрат в точке %s со стороной %d", firstPoint, firstSide);
    }


}
