package ru.kurbatov.oop.any.geometry.figures;

import ru.kurbatov.oop.any.geometry.points.Point2D;

public class Triangle extends Figure implements PolylineCalculable {

    private Point2D secondPoint;
    private Point2D thirdPoint;

    public Triangle(Point2D firstPoint, Point2D secondPoint, Point2D thirdPoint){
        super(firstPoint);
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    @Override
    public double getArea() {
        return Math.abs((secondPoint.getX() - firstPoint.getX()) * (thirdPoint.getY() - firstPoint.getY()) -
                (thirdPoint.getX() - firstPoint.getX()) * (secondPoint.getY() - firstPoint.getY()))/2;
    }

    @Override
    public double getLength() {
        return new Line(firstPoint, secondPoint).getLength()
                + new Line(secondPoint, thirdPoint).getLength()
                + new Line(thirdPoint, firstPoint).getLength();

    }

    @Override
    public Polyline getPolyline() {
        return new Polyline(firstPoint, secondPoint, thirdPoint);
    }

    @Override
    public String toString() {
        return firstPoint + " " + secondPoint + " " + thirdPoint;
    }
}
